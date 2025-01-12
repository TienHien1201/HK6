<template>
  <div class="container-coffe">
    <!-- Thanh tìm kiếm -->
    <div class="search-bar">
      <input
        type="text"
        v-model="searchQuery"
        placeholder="Tìm kiếm sản phẩm..."
        @input="validateSearchQuery"
      />
      <button @click="applySearch">🔍</button>
    </div>

    <div class="content">
      <!-- Bộ lọc bên trái -->
      <aside class="filter-section">
        <div class="filter-price">
          <h3>Khoảng giá</h3>
          <input
            type="number"
            v-model.number="priceFilter.min"
            placeholder="Từ"
            @input="validatePrice"
          />
          <input
            type="number"
            v-model.number="priceFilter.max"
            placeholder="Đến"
            @input="validatePrice"
          />
          <button @click="applyPriceFilter">Áp dụng</button>
        </div>
      </aside>

      <!-- Danh sách sản phẩm -->
      <div class="product-grid">
        <!-- Lọc sản phẩm theo các bộ lọc -->
        <div class="menu-item-coffes" v-for="product in filteredProducts" :key="product.id">
          <router-link
            :to="{ name: 'ProductDetail', params: { id: product.id } }"
            class="menu-item-link"
          >
            <img :src="product.image" :alt="product.name" class="menu-item-image" />
          </router-link>
          <div class="menu-item-info">
            <h3 class="menu-item-name">{{ product.name }}</h3>
            <p class="menu-item-price">{{ product.price }}</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { fetchProducts } from '../data/Product'; // Hàm lấy dữ liệu từ API

export default {
  name: 'ComCoffee',

  data() {
    return {
      products: [], // Lưu danh sách sản phẩm từ API
      searchQuery: '', // Từ khóa tìm kiếm
      priceFilter: { min: null, max: null }, // Bộ lọc giá
    };
  },

  computed: {
    // Lọc sản phẩm có type là 'coffee' và áp dụng bộ lọc
    filteredProducts() {
      return this.products
        .filter(product => {
          // Lọc sản phẩm theo tên tìm kiếm
          if (this.searchQuery && !product.name.toLowerCase().includes(this.searchQuery.toLowerCase())) {
            return false;
          }

          // Lọc sản phẩm theo khoảng giá
          if (this.priceFilter.min !== null && product.price < this.priceFilter.min) {
            return false;
          }
          if (this.priceFilter.max !== null && product.price > this.priceFilter.max) {
            return false;
          }

          // Chỉ hiển thị sản phẩm có type là 'coffee'
          return product.type.toLowerCase() === 'coffe';
        });
    },
  },

  mounted() {
    // Gọi API khi component được mount
    this.fetchData();
  },

  methods: {
    async fetchData() {
      try {
        const fetchedProducts = await fetchProducts(); // Lấy dữ liệu từ API
        this.products = fetchedProducts.filter(item => item.type === 'coffe'); // Gán vào danh sách sản phẩm
      } catch (error) {
        console.error('Lỗi khi lấy dữ liệu sản phẩm:', error);
      }
    },

    applySearch() {
      // Có thể áp dụng thêm các xử lý tìm kiếm tại đây
    },

    applyPriceFilter() {
      // Thực hiện áp dụng bộ lọc giá
    },

    validatePrice(event) {
      // Kiểm tra và chỉ cho phép nhập giá trị dương (không âm)
      if (event.target.value < 0) {
        event.target.value = 0;
      }
    },

    validateSearchQuery() {
      // Kiểm tra chỉ cho phép nhập ký tự chữ và số
      this.searchQuery = this.searchQuery.replace(/[^a-zA-Z0-9 ]/g, '');
    },
  },
};
</script>


<style scoped>
.title {
  color: #8b4513; /* Màu nâu cho thẻ h1 */
}

.title-description {
  color: #8b4513; /* Màu nâu cho thẻ p */
}

.container-coffe {
  margin-top: 100px;
}

.product-grid {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
}

.product-grid > * {
  flex: 0 0 calc(25% - 10px); /* 4 items per row */
  margin: 5px;
}

@media (max-width: 768px) {
  .product-grid > * {
    flex: 0 0 calc(50% - 10px); /* 2 items per row */
  }
}

@media (max-width: 480px) {
  .product-grid > * {
    flex: 0 0 calc(100% - 10px); /* 1 item per row */
  }
}

.container-coffe {
  padding-top: 20px;
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
