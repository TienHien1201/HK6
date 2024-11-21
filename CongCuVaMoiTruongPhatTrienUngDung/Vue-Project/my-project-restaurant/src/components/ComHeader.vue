<template>
  <header class="header">
    <div class="container">
      <div class="logo">
        <img src="../assets/News/IMG-FOOTER.png" alt="Coffe Logo" />
      </div>
      <nav>
        <ul>
          <li><router-link to="/">🏠Trang Chủ</router-link></li>
          <!-- Thêm menu Coffee và Tea -->
          <li class="dropdown">
            <a href="#">🧑🏻‍🍳Thực Đơn </a>
            <ul class="submenu">
              <li><router-link to="/coffee">☕Cà phê</router-link></li>
              <li><router-link to="/tea">🍵Trà</router-link></li>
            </ul>
          </li>
          <li><router-link to="/gioithieu">📝Giới thiệu</router-link></li>
          <li><router-link to="/lienhe">👨‍💻Liên Hệ</router-link></li>
          <li><router-link to="/tintuc">📰Tin Tức</router-link></li>
        </ul>
      </nav>
      <div class="cta-order">
        <div class="signout-info" v-if="user">
          <span class="welcome">{{ user.username }}</span>
          <button @click="SignOut">Sign Out</button>
        </div>
        <div v-else class="cta">
          <router-link to="/signin">
            <button>Sign In</button>
          </router-link>
          <router-link to="/signup">
            <button style="margin: 10px">Sign Up</button>
          </router-link>
        </div>

        <router-link to="/orderDetails">
          <button>Order Detail</button>
        </router-link>
        <router-link to="/cart" class="cta-button">
          🚚
          <span v-if="cartCount > 0" class="cart-count">{{ cartCount }}</span>
        </router-link>
      </div>
    </div>
  </header>
  <router-view />
</template>


<script>
import eventBus from '@/evenBus.js';

export default {
  data() {
    return {
      user: JSON.parse(localStorage.getItem('userCurrent')) || null,
      cartCount: 0, // Số lượng sản phẩm trong giỏ hàng
    };
  },
  created() {
    // Lắng nghe sự kiện khi người dùng đăng nhập thành công
    eventBus.on('loginSuccess', (user) => {
      this.user = user;
    });

    // Lắng nghe sự kiện 'cart-updated' để cập nhật số lượng sản phẩm trong giỏ hàng
    eventBus.on('cart-updated', (newCount) => {
      this.cartCount = newCount; // Cập nhật cartCount khi giỏ hàng thay đổi
    });
  },

  beforeUnmount() {
    eventBus.off('loginSuccess');
    eventBus.off('cart-updated'); // Hủy sự kiện khi component bị hủy
  },

  methods: {
    SignOut() {
      localStorage.removeItem('userCurrent');
      this.user = null;
    },
  },
};
</script>

<style>
.header {
  position: fixed; /* Đặt vị trí header là cố định */
  top: 0; /* Gắn header ở trên cùng */
  left: 0; /* Gắn header ở bên trái */
  right: 0; /* Gắn header ở bên phải */
  z-index: 1000; /* Đảm bảo header nằm trên các phần tử khác */
  background-color: #b6832c; /* Màu nền của header */
}

.container {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 20px;
}

.logo img {
  height: 50px;
  transition: transform 0.3s ease;
}

.cart-count {
  color: red; /* Màu sắc của số lượng */
  margin-left: 3px; /* Khoảng cách giữa biểu tượng giỏ hàng và số lượng */
}
nav ul {
  list-style: none;
  display: flex;
  margin: 0;
  padding: 0;
}

nav ul li {
  margin: 0 15px;
  position: relative; /* Để đặt submenu đúng vị trí */
}

nav ul li a {
  text-decoration: none;
  color: #fff;
  font-weight: bold;
  transition: color 0.3s ease;
}

nav ul li a:hover {
  color: #fcb034;
}

/* Thêm kiểu cho menu dropdown */
.dropdown .submenu {
  display: none;
  position: absolute;
  top: 100%; /* Đặt submenu ngay dưới menu cha */
  left: 0;
  background-color: #b6832c;
  padding: 10px 0;
  border-radius: 5px;
  min-width: 180px;
}

.dropdown:hover .submenu {
  display: block; /* Hiển thị submenu khi hover */
}

.submenu li {
  margin: 0;
}

.submenu li a {
  display: block;
  padding: 10px 20px;
  color: white;
  text-decoration: none;
  transition: background-color 0.3s ease;
}

.submenu li a:hover {
  background-color: #fcb034; /* Màu nền khi hover vào item trong submenu */
  color: #fff;
}

.cta {
  margin-right: 3px;
  height: 40px;
  width: 250px;
  border-radius: 25px;
  background: #b6832c;
  color: white;
  font-size: 14px;
  display: inline;
}
.cta-order button {
  margin-right: 3px;
  background: #fff;
  height: 40px;
  width: 100px;
  border: 2px solid #fff;
  border-radius: 25px;
  background: #b6832c;
  color: #fff;
  font-size: 14px;
}
.signout-info {
  margin-right: 3px;
  height: 40px;
  width: 250px;
  border-radius: 25px;
  background: #b6832c;
  color: white;
  font-size: 14px;
  display: inline;
}
.welcome {
  background: #b6832c;
  margin-left: 3px;
  color: white;
  font-size: 25px;
  font-weight: 800;
}
.signout-info button {
  padding: 10px 20px;
  margin-right: 3px;
  height: 40px;
  width: 100px;
  border: 2px solid #fff;
  border-radius: 25px;
  background: #b6832c;
  color: #fff;
  font-size: 14px;
  display: inline;
}
.signout-info button:hover {
  background: #fff;
  color: #b6832c;
}

.cta button {
  background: #fff;
  height: 40px;
  width: 100px;
  border: 2px solid #fff;
  border-radius: 25px;
  background: #b6832c;
  color: #fff;
  font-size: 14px;
}

.cta-button {
  padding: 10px 40px;
  background: #b6832c;
  color: #fff;
  text-decoration: none;
  border-radius: 25px;
  border: 2px solid #fff;
  transition: background-color 0.3s ease, transform 0.3s ease;
}

.cta-button:hover {
  background-color: white;
}

/* Không cần lề cho nội dung chính nữa */
.router-view {
  margin-top: 100px; /* Có thể điều chỉnh chiều cao nếu cần */
}

.wellcome {
  color: white;
  margin: 2px;
}
</style>
