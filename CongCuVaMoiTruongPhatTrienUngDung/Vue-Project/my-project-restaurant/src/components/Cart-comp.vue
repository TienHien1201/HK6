<template>
  <div class="modal-content">
    <div class="order-section">
      <div class="delivery-header">
        <h2 class="delivery-title">Giao hàng</h2>
        <button class="change-method">Đổi phương thức</button>
      </div>
      <div class="location-info">
        <img src="../assets/Delivery2.png" alt="delivery icon" class="delivery-icon" />
        <span>Thành phố Hồ Chí Minh, Hồ Chí Minh, Việt Nam</span>
      </div>
      <form @submit.prevent="handleSubmit">
        <input
          type="text"
          v-model="orderInfo.name"
          placeholder="Tên người nhận"
          required
          class="input-field"
        />
        <input
          type="tel"
          v-model="orderInfo.phone"
          placeholder="Số điện thoại"
          required
          class="input-field"
        />
        <input
          type="email"
          v-model="orderInfo.email"
          placeholder="Email người nhận"
          required
          class="input-field"
        />
        <input
          type="text"
          v-model="orderInfo.instructions"
          placeholder="Địa chỉ nhận hàng"
          class="input-field"
        />
        <h3>Phương thức thanh toán</h3>
        <div class="payment-options">
          <label>
            <input type="radio" value="tiền mặt" v-model="orderInfo.paymentMethod" /> Tiền mặt
          </label>
          <label>
            <input type="radio" value="MoMo" v-model="orderInfo.paymentMethod" /> MoMo
          </label>
          <label>
            <input type="radio" value="ZaloPay" v-model="orderInfo.paymentMethod" /> ZaloPay
          </label>
          <label>
            <input type="radio" value="ShopeePay" v-model="orderInfo.paymentMethod" /> ShopeePay
          </label>
          <label>
            <input type="radio" value="thẻ ngân hàng" v-model="orderInfo.paymentMethod" /> Thẻ ngân
            hàng
          </label>
        </div>
        <label>
          <input type="checkbox" required /> Đồng ý với các
          <a href="#">điều khoản và điều kiện</a>
        </label>
      </form>
      <div v-if="showSuccessMessage" class="success-message">
        <p>Thanh toán thành công!</p>
        <button @click="closeSuccessMessage">Đóng</button>
      </div>
    </div>
    <div class="cart-summary">
      <h2>Các món đã chọn</h2>
      <div class="cart-item" v-for="item in cart" :key="item.id">
        <img :src="item.image" style="height: 100px; width: 100px" />
        <div>{{ item.quantity }} x {{ item.name }}</div>
        <div>{{ item.selectedSize }}</div>
        <div>{{ item.selectedPrice }}</div>
        <button @click="decreaseQuantity(item)">-</button>
        <button @click="increaseQuantity(item)">+</button>
      </div>
      <div class="total-section">
        <div>Phí giao hàng: 25,000 VNĐ</div>
        <div class="parent-checkout-btn">
          <div class="final-price">
            <div>Thành tiền</div>
            <div class="price-amount">{{ totalPrice + 25000 }} VNĐ</div>
          </div>
          <button class="checkout-btn" @click="handleSubmit">Đặt hàng</button>
        </div>
        <button class="checkout-btn" @click="handleDeleteOrder">🗑️Xóa đơn hàng</button>
        <div v-if="showErrorMessage" class="error-message">Vui lòng điền đầy đủ thông tin</div>
        <div v-if="showLoginErrorMessage" class="error-message">
          Bạn cần đăng nhập để thực hiện đặt hàng!
          <button @click="closeLoginErrorMessage">Đóng</button>
        </div>
      </div>
    </div>
    <div v-if="showDeleteConfirmation" class="delete-confirmation-modal">
      <div class="modal-delete">
        <p>Bạn có chắc chắn muốn xoá toàn bộ đơn hàng không?</p>
        <div class="button-container">
          <button class="confirm-btn" @click="confirmDeleteOrder">Xác nhận</button>
          <button class="cancel-btn" @click="cancelDeleteOrder">Hủy</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import cart from '../data/Cart';
import eventBus from '@/evenBus.js';

export default {
  data() {
    return {
      cart: cart,
      orderInfo: {
        name: '',
        phone: '',
        email: '',
        instructions: '',
        paymentMethod: '',
      },
      showSuccessMessage: false,
      showDeleteConfirmation: false,
      showErrorMessage: false,
      showLoginErrorMessage: false,
      user: JSON.parse(localStorage.getItem('userCurrent')) || null,
      products: [], // Chứa các sản phẩm lấy từ API
    };
  },
  computed: {
    totalPrice() {
      return this.cart.reduce((total, item) => {
        const numericPrice = parseFloat(item.selectedPrice.replace(/[^0-9.-]+/g, ''));
        return total + item.quantity * numericPrice;
      }, 0);
    },
    totalQuantity() {
      return this.cart.reduce((total, item) => total + item.quantity, 0);
    },
  },
  async mounted() {
    // Lấy sản phẩm từ API
    try {
      const response = await axios.get(`http://localhost:3000/product`); // Thay API_URL_HERE bằng URL API thực tế
      this.products = response.data; // Cập nhật danh sách sản phẩm từ API
    } catch (error) {
      console.error('Error fetching products:', error);
    }
  },
  methods: {
    async deleteproduct(item) {
      // Lọc sản phẩm cần xóa khỏi giỏ hàng
      this.cart = this.cart.filter((x) => x.id !== item.id);
      this.updateCartCount();
    },
    async increaseQuantity(item) {
      // Tìm sản phẩm trong mảng products (đã lấy từ API)
      const prod = this.products.find((i) => i.id === item.id);

      if (prod && item.quantity < prod.quality) {
        item.quantity++;
      }
      this.updateCartCount();
    },
    async decreaseQuantity(item) {
      // Tìm sản phẩm trong mảng products (đã lấy từ API)
      const prod = this.products.find((i) => i.id === item.id);

      if (prod && item.quantity > 0) {
        item.quantity--;
        if (item.quantity <= 0) {
          this.deleteproduct(item);
        }
      }

      this.updateCartCount();
    },

    clearCart() {
      this.cart = [];

      this.updateCartCount();
    },
    updateCartCount() {
      const newCount = this.cart.reduce((total, item) => total + item.quantity, 0);
      eventBus.emit('cart-updated', newCount);
    },
    async handleSubmit() {
      if (!this.user) {
        this.showLoginErrorMessage = true;
        return;
      }

      if (
        !this.orderInfo.name ||
        !this.orderInfo.phone ||
        !this.orderInfo.email ||
        !this.orderInfo.instructions ||
        !this.orderInfo.paymentMethod
      ) {
        this.showErrorMessage = true;
        return;
      }
      this.showErrorMessage = false;

      const currentDate = new Date();
      const dateOrder = currentDate.toISOString();

      const order = {
        name: this.orderInfo.name,
        details: this.cart.map((item) => ({
          image: item.image,
          quantity: item.quantity,
          name: item.name,
          selectedSize: item.selectedSize,
          selectedPrice: item.selectedPrice,
        })),
        paymentMethod: this.orderInfo.paymentMethod,
        address: this.orderInfo.instructions,
        totalPrice: this.totalPrice + 25000,
        dateOrder: dateOrder,
      };

      try {
        // Gửi đơn hàng lên API hoặc lưu lịch sử đơn hàng
        await axios.post('http://localhost:3000/orderHistory', order);

        // Cập nhật số lượng tồn kho cho từng sản phẩm trong giỏ hàng
        for (let item of this.cart) {
          try {
            // Lấy thông tin sản phẩm hiện tại từ API
            const response = await axios.get(`http://localhost:3000/products/${item.id}`);
            const product = response.data;

            if (product) {
              // Tính toán số lượng mới
              const newQuality = product.quality - item.quantity;

              if (newQuality >= 0) {
                // Cập nhật sản phẩm với số lượng mới
                await axios.put(`http://localhost:3000/products/${item.id}`, {
                  ...product, // Duy trì các trường hiện tại
                  quality: newQuality, // Cập nhật số lượng tồn kho
                });
              }
            }
          } catch (error) {
            console.error(`Lỗi khi cập nhật sản phẩm có ID ${item.id}:`, error);
          }
        }

        // Xóa giỏ hàng sau khi thanh toán thành công
        this.cart = [];
        alert('Thanh toán thành công!');
      } catch (error) {
        console.error('Lỗi khi xử lý thanh toán:', error);
        alert('Đã xảy ra lỗi khi thanh toán!');
      }
    },

    handleDeleteOrder() {
      this.showDeleteConfirmation = true;
    },
    confirmDeleteOrder() {
      this.clearCart();
      this.showDeleteConfirmation = false;
    },
    cancelDeleteOrder() {
      this.showDeleteConfirmation = false;
    },
    closeSuccessMessage() {
      this.showSuccessMessage = false;
    },
    closeLoginErrorMessage() {
      this.showLoginErrorMessage = false;
    },
  },
  created() {
    const storedCart = localStorage.getItem('cart');
    if (storedCart) {
      this.cart = JSON.parse(storedCart);
    }
  },

};
</script>

<style>
.modal-content {
  display: flex;
  background-color: #f7f7f7;
  padding-top: 60px;
}
.order-section,
.cart-summary {
  flex: 1;
  padding: 20px;
  background-color: #fff;
  border-radius: 10px;
  margin-right: 10px;
}
h2 {
  color: #ffba00;
  font-weight: bold;
}
.delivery-icon {
  width: 24px;
  margin-right: 10px;
}
.input-field {
  width: 100%;
  padding: 10px;
  margin: 10px 0;
  border: 1px solid #ddd;
  border-radius: 5px;
}
.payment-options {
  display: flex;
  flex-direction: column;
  margin: 10px 0;
}
.payment-options label {
  margin-bottom: 5px;
}
.total-section {
  border-top: 1px solid #ddd;
  padding-top: 20px;
}
.parent-checkout-btn {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: #ff6f00;
  padding: 10px;
  border-radius: 10px;
}

.final-price {
  color: white;
  font-size: 18px;
  font-weight: bold;
}

.checkout-btn {
  padding: 10px 20px;
  margin: 0;
  border: none;
  font-size: 16px;
  background-color: white;
  color: #ff6f00;
  border-radius: 10px;
  cursor: pointer;
}
.price-amount {
  font-style: italic;
  font-size: 20px; /* Kích thước chữ lớn hơn cho số tiền */
  color: white; /* Màu sắc nổi bật cho số tiền */
}
.success-message {
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  background-color: #4caf50;
  color: white;
  padding: 20px;
  border-radius: 5px;
  box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.2);
  z-index: 1000;
}
/* Thêm kiểu cho modal xác nhận xoá đơn hàng */
.delete-confirmation-modal {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: rgba(0, 0, 0, 0.5);
  display: flex;
  align-items: center;
  justify-content: center;
  z-index: 1000;
}
.modal-delete {
  background: white;
  padding: 20px;
  border-radius: 8px;
  text-align: center;
  max-width: 400px;
  width: 100%;
}
.button-container {
  display: flex;
  justify-content: center;
  gap: 10px;
  margin-top: 20px; /* Khoảng cách giữa dòng thông báo và các nút */
}

.confirm-btn {
  background-color: #d9534f;
  color: white;
  border: none;
  padding: 10px 20px;
  cursor: pointer;
  border-radius: 5px;
}

.cancel-btn {
  background-color: #5bc0de;
  color: white;
  border: none;
  padding: 10px 20px;
  cursor: pointer;
  border-radius: 5px;
}
.error-message {
  color: red;
  margin-top: 10px;
}
</style>
