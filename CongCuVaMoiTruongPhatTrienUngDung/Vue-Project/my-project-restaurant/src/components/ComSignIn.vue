<template>
  <div class="login-container">
    <!-- Background Image -->
    <img src="../assets/News/ImgBG.png" alt="Background" class="background-img" />

    <!-- Login Form -->
    <div class="login-form">
      <h2>Đăng Nhập</h2>
      <input v-model="username" type="text" placeholder="Email/Số điện thoại/Tên đăng nhập" />
      <input v-model="password" type="password" placeholder="Mật khẩu" />
      <button @click="SignIn">ĐĂNG NHẬP</button>
      <P v-if="error">{{ error }}</P>
      <div class="login-options">
        <a href="#">Quên mật khẩu</a>
        <span>HOẶC</span>
        <a href="#">Đăng nhập với SMS</a>
      </div>
      <div class="social-login">
        <button>Facebook</button>
        <button>Google</button>
      </div>
      <p>Bạn mới biết đến ABC? <router-link to="/signup">Đăng ký</router-link></p>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import eventBus from '@/evenBus';
export default {
  name: 'ComSignIn',
  data() {
    return {
      username: '', //an
      password: '', //1234
      error: '',
    };
  },
  methods: {
    async SignIn() {
      const response = await axios.get('http://localhost:3000/user');
      const users = response.data;

      const trimmedUsername = this.username.trim();
      const trimmedPassword = this.password.trim();

      const user = users.find(
        (x) => x.username === trimmedUsername && x.password === trimmedPassword
      );
      if (user) {
        // Lưu thông tin vào local
        localStorage.setItem('userCurrent', JSON.stringify(user));
        eventBus.emit('loginSuccess', user);
        this.$router.push('/');
      } else {
        this.error = 'Tên đăng nhập, mật khẩu không đúng';
      }
    },
  },
};
</script>

<style scoped>
.login-container {
  position: relative;
  width: 100%;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
}

.background-img {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  object-fit: cover;
  z-index: -1;
}

.login-form {
  background-color: #c6a464;
  padding: 20px;
  border-radius: 10px;
  width: 300px;
  text-align: center;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
}

.login-form h2 {
  margin-bottom: 20px;
}.login-form input {
  width: 100%; /* Đảm bảo chiều rộng bằng nhau */
  padding: 12px; /* Điều chỉnh padding cho đồng đều */
  margin: 10px 0; /* Khoảng cách giữa các ô input */
  border: 1px solid #ddd; /* Đường viền nhẹ */
  border-radius: 5px; /* Góc bo tròn */
  box-sizing: border-box; /* Đảm bảo padding được tính vào tổng chiều rộng */
  font-size: 14px; /* Căn chỉnh kích thước chữ cho đồng đều */
}

.login-form button {
  width: 100%; /* Đảm bảo nút có cùng chiều rộng với ô input */
  padding: 12px; /* Padding giống như input */
  margin: 10px 0; /* Khoảng cách giữa các nút và input */
  background-color: #ff5722; /* Màu nền */
  color: white; /* Màu chữ */
  border: none; /* Không có viền */
  border-radius: 5px; /* Góc bo tròn */
  cursor: pointer; /* Con trỏ khi rê chuột */
  box-sizing: border-box; /* Đảm bảo padding được tính vào tổng chiều rộng */
  font-size: 14px; /* Kích thước chữ cho nút */
}

/* Các button đăng nhập với Facebook và Google */
.social-login button {
  width: 45%; /* Chiếm 45% chiều rộng */
  padding: 12px; /* Padding giống như input */
  margin-top: 10px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  font-size: 14px; /* Kích thước chữ cho nút */
}

.social-login button:first-child {
  background-color: #3b5998; /* Màu Facebook */
  color: white;
}

.social-login button:last-child {
  background-color: #db4437; /* Màu Google */
  color: white;
}


.login-form p {
  margin-top: 20px;
  font-size: 0.9em;
}

.login-form p a {
  color: #ff5722;
  text-decoration: none;
}
</style>
