<template>
  <div class="container-home">
    <!-- Automatic Slideshow -->
    <div class="slideshow-container">
      <img :src="slideshowImages[currentImageIndex]" class="slideshow-image" />
    </div>
    <section class="product-section">
      <h2>🏆 Sản phẩm từ Nhà House 😀</h2>

      <!-- Product List for Coffee -->
      <div class="product-coffe-list">
        <div class="product-grid">
          <ComCoffeeVue/>
        </div>
      </div>
      <h2>THỰC ĐƠN MÓN KHÁC (FOOD MENU)</h2>
      <!-- Product List for Tea -->
      <div class="product-tea-list">
        <div class="product-grid_container">
        <div v-for="item in fillterproductTeas" :key="item.id" class="menu-item-coffes">
           <img :src="item.image" alt="Product Image" class="menu-item-image" />
      
      <!-- Hiển thị tên sản phẩm -->
      <h3 class="menu-item-name">{{ item.name }}</h3>
      
      <!-- Hiển thị giá sản phẩm -->
      <p class="menu-item-price"><strong>Giá:</strong> {{ item.price }} VND</p>
        </div>
      </div>
      <div class="pagination">
        <button @click="changpage(currentpage - 1)" :disabled="currentpage === 1">
          Trang trước
        </button>
        <button
          v-for="page in toltalpageTea"
          :key="page"
          @click="changpage(page)"
          :class="{ active: page === currentpage }"
        >
          {{ page }}
        </button>
        <button @click="changpage(currentpage + 1)" :disabled="currentpage === toltalpageTea">
          Trang sau
        </button>
      </div>
      </div>
    </section>

    <!-- News Section -->
    <section class="news-section">
      <h2>📰 Tin Tức</h2>
      <div class="news-list">
        <div class="news-item" v-for="news in fillterproductNews" :key="news.id">
          <img :src="news.image" alt="news image" class="news-image" />
          <h3>{{ news.title }}</h3>
          <p>{{ news.description }}</p>
          <button class="read-more">Đọc Tiếp</button>
        </div>
      </div>
      <div class="pagination">
        <button @click="changpage(currentpage - 1)" :disabled="currentpage === 1">
          Trang trước
        </button>
        <button
          v-for="page in toltalpageNews"
          :key="page"
          @click="changpage(page)"
          :class="{ active: page === currentpage }"
        >
          {{ page }}
        </button>
        <button @click="changpage(currentpage + 1)" :disabled="currentpage === toltalpageNews">
          Trang sau
        </button>
      </div>
    </section>

    <!-- Store List Section -->
    <section class="store-section">
      <h2>Danh sách cửa hàng</h2>
      <div class="store-list">
        <div v-for="store in displayedStores" :key="store.id" class="store-item">
          <h3>{{ store.name }}</h3>
          <p><strong>Địa chỉ:</strong> {{ store.address }}</p>
          <p><strong>Số điện thoại:</strong> {{ store.phone }}</p>
          <p><strong>Giờ hoạt động:</strong> {{ store.hours }}</p>
          <p><strong>Trạng thái:</strong> {{ store.status }}</p>
          <button class="directions-button">
            <router-link to="/maps"> Chỉ đường </router-link>
          </button>
        </div>
        <button @click="loadMoreStores" class="see-more-button">
          {{ showMore ? '^' : 'Xem thêm' }}
        </button>
      </div>
    </section>
  </div>
</template>

<script>
import TinTucItems from '@/data/TinTuc';
import storeList from '@/data/storeList';
import ComCoffeeVue from './ComCoffee.vue';
import { fetchProducts } from '../data/Product';
export default {
  name: 'ComHome',
  components:{
    ComCoffeeVue
  },
  data() {
    return {
      showMore: false,
      currentpage: 1,
      limit: 4,
      slideshowImages: [
        require('@/assets/IntroHomeImg.jpg'),
        require('@/assets/IntroHomeImg2.png'),
      ],
      currentImageIndex: 0,
      newsItems: TinTucItems,
      storeList: storeList,
      teaProducts: [], // Sản phẩm trà, có thể lọc từ 'products'
    };
  },
  computed: {
    toltalpage() {
      return Math.ceil(this.products.length / this.limit);
    },
    toltalpageTea() {
      return Math.ceil(this.teaProducts.length / this.limit); 
    },
    fillterproductCoffe() {
      const coffeProducts = this.products.filter(
        (product) => product.type.toLowerCase() === 'coffe'
      );
      const start = (this.currentpage - 1) * this.limit;
      const end = start + this.limit;
      return coffeProducts.slice(start, end);
    },
    fillterproductTeas() {
      const start = (this.currentpage - 1) * this.limit;
      const end = start + this.limit;
      return this.teaProducts.slice(start, end);
    },
    fillterproductNews() {
      const start = (this.currentpage - 1) * this.limit;
      const end = start + this.limit;
      return this.newsItems.slice(start, end);
    },
  },
  mounted() {
    this.fetchData(); 
    this.startSlideshow();
  },
  methods: {
    // Hàm lấy dữ liệu từ API
    async fetchData() {
      try {
           const fetchedProducts = await fetchProducts(); // Lấy dữ liệu từ API
        this.teaProducts = fetchedProducts.filter((item) => item.type == 'Tea'); // Gán vào danh sách sản phẩm
      
        
      } catch (error) {
        console.error("Error fetching products:", error);
      }
    },
    changpage(page) {
      if (page >= 1 && page <= this.toltalpageTea) {
        this.currentpage = page;
      }
    },
    startSlideshow() {
      setInterval(() => {
        this.currentImageIndex = (this.currentImageIndex + 1) % this.slideshowImages.length;
      }, 3000);
    },
    loadMoreStores() {
      if (this.showMore) {
        this.displayedStores = this.storeList.slice(0, 2);
        this.showMore = false;
      } else {
        const moreStores = [
          { id: 4, name: 'HCM-CH Bitexco', address: 'Tòa nhà Bitexco, Quận 1, TP. Hồ Chí Minh', phone: '(028) 3821 8888', hours: '09:00 - 22:00', status: 'Mở cửa' },
          { id: 5, name: 'HCM-CH Landmark 81', address: 'Landmark 81, Quận Bình Thạnh, TP. Hồ Chí Minh', phone: '(028) 3775 1888', hours: '09:00 - 22:00', status: 'Mở cửa' }
        ];
        this.storeList = [...this.storeList, ...moreStores];
        this.displayedStores = this.storeList;
        this.showMore = true;
      }
    },
  },
};
</script>


<style scoped>
.product-section h2 {
  text-align: center;
  font-weight: bold;
  margin-bottom: 20px;
}

.product-categories {
  display: flex;
  justify-content: center;
  gap: 10px;
  margin-bottom: 20px;
}

.category {
  background: #f9f9f9;
  border-radius: 50px;
  padding: 10px 20px;
  cursor: pointer;
  transition: 0.3s;
}

.category:hover {
  background: #ff9800;
  color: white;
}

/* Product Grid Styling */
.product-grid {
  display: flex;
  flex-wrap: wrap; /* Cho phép sản phẩm xuống hàng nếu không đủ chỗ */
  justify-content: space-between; /* Giãn cách đều giữa các sản phẩm */
}
.product-grid > * {
  flex: 1 1 calc(20% - 10px); /* Chiều rộng 20% cho tối đa 5 sản phẩm, cho phép giãn ra */
  margin: 5px; /* Khoảng cách giữa các sản phẩm */
  box-sizing: border-box; /* Đảm bảo padding và border không ảnh hưởng đến kích thước */
}

@media (max-width: 768px) {
  .product-grid > * {
    flex: 0 0 calc(50% - 10px); /* Đặt chiều rộng 50% trên màn hình nhỏ */
  }
}

@media (max-width: 480px) {
  .product-grid > * {
    flex: 0 0 calc(100% - 10px); /* Đặt chiều rộng 100% trên màn hình rất nhỏ */
  }
}

/* News Section Styling */
.news-section h2 {
  text-align: center;
  font-weight: bold;
  margin-top: 40px;
  margin-bottom: 20px;
}

.news-list {
  display: grid;
  grid-template-columns: repeat(4, 1fr); /* Tối đa 4 cột */
  gap: 20px; /* Khoảng cách giữa các mục tin */
  width: 100%; /* Bảo đảm danh sách phủ hết chiều ngang */
  max-width: 1200px; /* Tùy chỉnh giới hạn tối đa */
  margin: 0 auto; /* Canh giữa danh sách */
}

@media (max-width: 1024px) {
  .news-list {
    grid-template-columns: repeat(3, 1fr); /* Hiển thị tối đa 3 cột trên màn hình nhỏ hơn */
  }
}

@media (max-width: 768px) {
  .news-list {
    grid-template-columns: repeat(2, 1fr); /* Hiển thị tối đa 2 cột trên màn hình nhỏ */
  }
}

@media (max-width: 480px) {
  .news-list {
    grid-template-columns: 1fr; /* Hiển thị 1 cột trên màn hình rất nhỏ */
  }
}

.news-item {
  background: white;
  padding: 15px;
  border-radius: 10px;
  text-align: center;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.news-image {
  width: 100%;
  height: auto;
  border-radius: 10px;
}

.read-more {
  margin-top: 10px;
  background-color: #ff9800;
  color: white;
  padding: 10px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: 0.3s;
}

.read-more:hover {
  background-color: #ff5722;
}
/* Store Section Styling */
.store-section h2 {
  text-align: center;
  font-weight: bold;
  margin-top: 40px;
  margin-bottom: 20px;
}

.see-more-button {
  display: block;
  margin: 0 auto 20px;
  padding: 10px 20px;
  background-color: #00aaff;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: 0.3s;
  align-self: center;
}

.see-more-button:hover {
  background-color: #0088cc;
}

.store-list {
  display: flex;
  flex-direction: column;
  gap: 20px;
  padding: 0 20px;
}

.store-item {
  background: white;
  padding: 15px;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.store-item h3 {
  font-size: 18px;
  margin-bottom: 5px;
}

.directions-button {
  margin-top: 10px;
  background-color: #00aaff;
  color: white;
  padding: 8px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: 0.3s;
}

.directions-button:hover {
  background-color: #0088cc;
}

/* Store Section Styling */
.store-section h2 {
  text-align: center;
  font-weight: bold;
  margin-top: 40px;
  margin-bottom: 20px;
}

.see-more-button {
  display: block;
  margin: 0 auto 20px;
  padding: 10px 20px;
  background-color: #00aaff;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: 0.3s;
}

.see-more-button:hover {
  background-color: #0088cc;
}

.store-list {
  display: flex;
  flex-direction: column;
  gap: 20px;
  padding: 0 20px;
}

.store-item {
  background: white;
  padding: 15px;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.store-item h3 {
  font-size: 18px;
  margin-bottom: 5px;
}

.directions-button {
  margin-top: 10px;
  background-color: #00aaff;
  color: white;
  padding: 8px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: 0.3s;
}

.directions-button:hover {
  background-color: #0088cc;
}.slideshow-container {
    background-image: url('../assets/News/ImgBG.png');
  padding-top: 20px;
  width: 100%;
  height: 500px; /* Bạn có thể điều chỉnh chiều cao của slider ở đây */
  overflow: hidden;
  position: relative;
}

.slideshow-image {
  width: 100%;
  height: 100%;
  object-fit: cover; /* Đảm bảo ảnh sẽ bao phủ toàn bộ phần tử container mà không bị méo */
}

/* Pagination Styles */
.pagination {
  display: flex;
  justify-content: center;
  gap: 5px;
  margin-top: 20px;
}
.pagination button {
  background-color: #f9f9f9;
  border: 1px solid #ddd;
  padding: 8px 12px;
  border-radius: 5px;
  cursor: pointer;
  transition: 0.3s;
}
.pagination button.active {
  background-color: #ff9800;
  color: white;
}
.pagination button:disabled {
  background-color: #ccc;
  cursor: not-allowed;
}

/* ################################# */

.product-grid_container {
  display: flex;
  flex-wrap: wrap; /* Cho phép các sản phẩm xuống hàng nếu không đủ chỗ */
  justify-content: space-between; /* Giãn cách đều giữa các sản phẩm */
}

.product-grid_container > * {
  flex: 0 0 calc(25% - 10px); /* Chiều rộng 25% cho tối đa 4 sản phẩm, trừ khoảng cách */
  margin: 5px; /* Khoảng cách giữa các sản phẩm */
}

@media (max-width: 768px) {
  .product-grid_container > * {
    flex: 0 0 calc(50% - 10px); /* Đặt chiều rộng 50% trên màn hình nhỏ */
  }
}

@media (max-width: 480px) {
  .product-grid_container > * {
    flex: 0 0 calc(100% - 10px); /* Đặt chiều rộng 100% trên màn hình rất nhỏ */
  }
}
.container-coffe {
  background-color: #fff;
}
.menu-item-coffes {
  position: relative;
  width: 200px;
  padding: 0;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
  margin: 10px auto;
  background-color: #fff;
  overflow: hidden;
  transition: transform 0.3s ease;
}

.menu-item-coffes:hover {
  transform: scale(1.05);
}

.menu-item-link {
  display: block;
  text-decoration: none;
  color: inherit;
  border: 3px solid #b6832c; /* Thêm viền với màu #b6832c */
}

.menu-item-image {
  width: 150px;
  height: 150px;
  object-fit: cover;
}

.new-badge {
  position: absolute;
  top: 10px;
  left: 10px;
  background-color: orange;
  color: #fff;
  padding: 5px 10px;
  font-size: 12px;
  font-weight: bold;
  border-radius: 5px;
}

.menu-item-info {
  padding: 10px;
  text-align: center;
  background-color: #fff;
  border-top: 1px solid #eee;
  border: 3px solid #b6832c; /* Thêm viền với màu #b6832c */
}

.menu-item-name {
  font-size: 16px;
  font-weight: bold;
  margin: 0;
  color: #333;
}

.menu-item-price {
  font-size: 14px;
  color: #888;
  margin: 5px 0;
}
</style>
