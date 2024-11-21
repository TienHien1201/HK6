<template>
  <div class="container-tea">
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
        <div class="menu-item-tea" v-for="product in filteredProducts" :key="product.id">
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
  name: 'ComTea',
  data() {
    return {
      products: [], // Lưu danh sách sản phẩm từ API
      searchQuery: '', // Từ khóa tìm kiếm
      priceFilter: { min: null, max: null }, // Bộ lọc giá
      selectedTypes: [], // Bộ lọc loại sản phẩm
      uniqueTypes: [], // Danh sách các loại sản phẩm duy nhất
    };
  },

  computed: {
    // Sản phẩm đã được lọc theo bộ lọc
    filteredProducts() {
      return this.products.filter((product) => {
        // Bộ lọc theo loại sản phẩm
        if (this.selectedTypes.length > 0 && !this.selectedTypes.includes(product.type)) {
          return false;
        }
        // Bộ lọc theo giá
        if (this.priceFilter.min !== null && product.price < this.priceFilter.min) {
          return false;
        }
        if (this.priceFilter.max !== null && product.price > this.priceFilter.max) {
          return false;
        }
        // Bộ lọc theo tên sản phẩm
        if (
          this.searchQuery &&
          !product.name.toLowerCase().includes(this.searchQuery.toLowerCase())
        ) {
          return false;
        }
        return true;
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
        this.products = fetchedProducts.filter((item) => item.type == 'Tea'); // Gán vào danh sách sản phẩm
        // Lấy danh sách các loại sản phẩm duy nhất
        this.uniqueTypes = [...new Set(fetchedProducts.map((product) => product.type))];
      } catch (error) {
        console.error('Lỗi khi lấy dữ liệu sản phẩm:', error);
      }
    },

    applySearch() {
      // Thực hiện thao tác sau khi tìm kiếm, ví dụ cập nhật danh sách sản phẩm theo từ khóa.
    },

    applyPriceFilter() {
      // Thực hiện áp dụng bộ lọc giá
    },

    validatePrice(event) {
      // Kiểm tra giá trị nhập vào không phải là số âm
      if (event.target.value < 0) {
        event.target.value = 0;
      }
    },

    validateSearchQuery() {
      // Kiểm tra chỉ cho phép nhập số hoặc chữ, không cho phép ký tự đặc biệt
      this.searchQuery = this.searchQuery.replace(/[^a-zA-Z0-9 ]/g, '');
    },
  },
};
</script>


<style scoped>
.title-tea {
  color: #138b27; /* Màu xanh lá cho thẻ h1 */
}

.description-tea {
  color: #138b27; /* Màu xanh lá cho thẻ p */
}

.container-tea {
  margin-top: 100px; /* Có thể điều chỉnh chiều cao nếu cần */
}

.product-grid {
  display: flex;
  flex-wrap: wrap; /* Cho phép các sản phẩm xuống hàng nếu không đủ chỗ */
  justify-content: space-between; /* Giãn cách đều giữa các sản phẩm */
}

.product-grid > * {
  flex: 0 0 calc(25% - 10px); /* Chiều rộng 25% cho tối đa 4 sản phẩm, trừ khoảng cách */
  margin: 5px; /* Khoảng cách giữa các sản phẩm */
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
.container-tea {
  padding-top: 20px;
  background-color: #fff;
}
.menu-item-tea {
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
