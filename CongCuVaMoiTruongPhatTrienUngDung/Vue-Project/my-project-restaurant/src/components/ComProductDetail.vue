<template>
  <div class="menu-Detail_parent">
    <div class="menu-Detail_container">
      <div class="menu-item-detail">
        <img :src="product.image" alt="Juice" class="menu-item-image" />
        <div class="menu-item-detail-info">
          <h3>{{ product.name }}</h3>
          <p>{{ product.description }}</p>
          <p class="Product-Pice">{{ selectedPrice }}</p>
          <p>Số lượng còn: {{ product.quality }}</p>

          <!-- Chọn kích thước -->
          <div class="size-selection">
            <h4>Chọn kích thước</h4>
            <div class="size-options">
              <div v-for="size in sizes" :key="size.id">
                <input
                  type="radio"
                  :id="'size-' + size.id"
                  :value="size.type"
                  v-model="selectedSize"
                  @change="updatePrice(size.price)"
                />
                <label :for="'size-' + size.id">{{ size.type }}</label>
              </div>
            </div>
          </div>
        </div>
        <div class="add-item">
          <div v-if="parseInt(product.quality) === 0">Hết hàng</div>
          <div v-else>
            <button
              class="add-to-cart-button"
              @click="addToCart(product, selectedSize, selectedPrice)"
            >
              🛒
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import cart from '@/data/Cart';
import eventBus from '@/evenBus.js';
export default {
  data() {
    return {
      product: {},
      cart: cart,
      selectedSize: '', // Biến để lưu kích thước đã chọn
      selectedPrice: '', // Biến để lưu giá đã chọn
      sizes: [], // Khởi tạo sizes là mảng rỗng
    };
  },
  async mounted() {
    const id = this.$route.params.id; // Lấy ID từ URL
    try {
      const response = await axios.get(`http://localhost:3000/product/${id}`);
      this.product = response.data; // Lưu dữ liệu sản phẩm vào product
      this.sizes = this.product.size || []; // Cập nhật danh sách kích thước
      if (this.sizes.length > 0) {
        this.selectedSize = this.sizes[0].type; // Chọn kích thước đầu tiên
        this.selectedPrice = this.sizes[0].price; // Cập nhật giá ban đầu
      }
    } catch (error) {
      console.error('Error fetching product details:', error);
    }
  },
  methods: {
    updatePrice(newPrice) {
      this.selectedPrice = newPrice; // Cập nhật giá khi chọn kích thước
    },
    addToCart(product, size, price) {
      // Tìm sản phẩm trong giỏ hàng dựa trên ID và kích thước đã chọn
      const infoproduct = this.cart.find(
        (item) => item.id === product.id && item.selectedSize === size
      );

      // Nếu sản phẩm đã tồn tại trong giỏ hàng
      if (infoproduct) {
        if (infoproduct.quantity < product.quality) {
          infoproduct.quantity += 1; // Đúng logic
          console.log(this.cart); // Log lại giỏ hàng
        } else {
          alert('Không thể thêm sản phẩm, đã hết hàng trong kho!');
        }
      } else {
        if (product.quality > 0) {
          const newproduct = {
            ...product,
            selectedSize: size,
            selectedPrice: price.toString(),
            quantity: 1,
          };
          this.cart.push(newproduct);

          console.log('Sản phẩm mới trong giỏ:', newproduct); // Log sản phẩm được thêm
          console.log('Giỏ hàng:', this.cart); // Log toàn bộ giỏ hàng
        } else {
          alert('Sản phẩm đã hết hàng!');
        }
      }
      // Tính tổng số lượng sản phẩm trong giỏ hàng
      const newCount = this.cart.reduce((sum, item) => sum + item.quantity, 0);
      // Phát sự kiện cập nhật giỏ hàng
      eventBus.emit('cart-updated', newCount);
    },

    // // Hàm cập nhật giỏ hàng vào localStorage
    // updateLocalStorage() {
    //   // Xóa tất cả sản phẩm không hợp lệ (ví dụ hết hàng) khỏi giỏ hàng trước khi lưu lại
    //   this.cart = this.cart.filter((item) => item.quality > 0);

    //   // Lưu giỏ hàng vào localStorage
    //   localStorage.setItem('cart', JSON.stringify(this.cart));
    // },
  },
};
</script>

<style scoped>
.menu-item-detail {
  display: flex; /* Sử dụng flexbox để sắp xếp ảnh và thông tin */
  align-items: flex-start; /* Căn lề cho phần thông tin bên trái */
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2); /* Khung nổi */
  border-radius: 8px;
  margin: 20px 0; /* Khoảng cách giữa các mục */
  overflow: hidden; /* Đảm bảo không bị tràn ra ngoài khung */
  background-color: #fff; /* Màu nền cho khung */
}

.menu-item-image {
  width: 300px; /* Độ rộng của ảnh */
  height: auto; /* Giữ tỉ lệ cho ảnh */
  align-self: center; /* Căn giữa ảnh */
  border-radius: 8px; /* Bo tròn góc cho ảnh */
}

.menu-item-detail-info {
  padding: 20px; /* Thêm khoảng cách cho thông tin */
  text-align: left;
  flex: 1; /* Chiếm hết không gian còn lại */
}

.size-selection {
  margin-top: 10px; /* Khoảng cách giữa kích thước và mô tả */
  text-align: left; /* Căn lề trái cho văn bản */
}

.size-options {
  display: flex; /* Hiển thị các lựa chọn kích thước theo hàng ngang */
  gap: 10px; /* Khoảng cách giữa các radio button */
}

.menu-item-detail-info h3 {
  font-size: 40px; /* Kích thước tiêu đề */
  margin: 0 0 10px;
  font-style: italic;
  color: orange;
}

.menu-item-detail-info p {
  margin: 0 0 5px; /* Khoảng cách giữa các đoạn văn */
}
.add-to-cart-button {
  margin-top: 10px;
  width: 30px;
  height: 30px;
  background-color: #ff8c00;
  border: none;
  color: #fff;
  font-size: 18px;
  font-weight: bold;
  border-radius: 50%;
  display: inline-flex;
  align-items: center;
  justify-content: center;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.add-to-cart-button:hover {
  background-color: #e67e00;
}
.menu-Detail_container {
  padding-top: 20px;
}
.menu-item-detail {
  width: 400px; /* Chiều rộng cố định cho khối vuông */
  height: 670px; /* Chiều cao cố định cho khối vuông */
  margin: 50px auto; /* Căn giữa theo chiều ngang với margin tự động */
  display: flex; /* Sử dụng flexbox */
  flex-direction: column; /* Xếp theo chiều dọc */
  justify-content: center; /* Căn giữa nội dung theo chiều dọc */
  align-items: flex-start; /* Căn trái nội dung */
  padding: 20px; /* Padding bên trong khối */
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2); /* Đổ bóng cho khối */
  border-radius: 8px; /* Bo tròn góc khối */
  background-color: #fff; /* Màu nền cho khối */
  border: 3px solid #b6832c; /* Thêm viền với màu #b6832c */
}

.Product-Pice {
  font-size: 20px;
  font-weight: bold;
  color: #218838;
}
.add-item {
  align-self: center;
  width: 40px;
}
</style>
