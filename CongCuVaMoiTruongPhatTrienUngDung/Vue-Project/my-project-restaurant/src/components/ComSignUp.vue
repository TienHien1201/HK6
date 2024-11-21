<template>
  <div class="login-container">
    <!-- Background Image -->
    <img src="../assets/News/ImgBG.png" alt="Background" class="background-img" />
    <!-- Hiển thị thông báo lỗi nếu có -->
    <!-- Login Form -->
    <div class="login-form">
      <h2>Đăng Kí</h2>
      <input v-model="username" type="text" placeholder="Tên đăng kí" />
      <input v-model="password" type="password" placeholder="Mật khẩu" />
      <input v-model="confirmPassword" type="password" placeholder="Xác nhận mật khẩu" />
      <button @click="register">ĐĂNG KÍ</button>
      <p v-if="error" class="error-message">{{ error }}</p>

      <div class="social-login">
        <button>Facebook</button>
        <span>HOẶC</span>
        <button>Google</button>
      </div>
      <p>
        Bạn mới biết đến ABC?
        <routerLink to="/signin"> Đăng Nhập</routerLink>
      </p>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import users from '@/data/user';
export default {
  name: 'ComSignUp',
  data() {
    return {
      username: '', //an
      password: '', //123
      confirmPassword: '', //123
      error: '',
      success: '',
      users: users,
    };
  },
  methods: {
    async register() {
      if (this.password !== this.confirmPassword) {
        this.error = 'Mật khẩu không đúng';
        return;
      }

      // Kiểm tra xem user có tồn tại trong localStorage chưa

      const response = await axios.get('http://localhost:3000/user');
      const users = response.data;
      const userExists = users.find((x) => x.username === this.username);
      if (userExists) {
        alert('trung ten');
      }

      // Tạo 1 đối tượng người dùng mới
      const userNew = {
        id: users.length + 1,
        username: this.username,
        password: this.password,
      }; // id tự động bằng cách lấy độ dài của mảng
      await axios.post('http://localhost:3000/user', userNew);

      // Thêm người dùng mới vào mảng users
      users.push(userNew);



      // Reset các giá trị
      this.username = '';
      this.password = '';
      this.confirmPassword = '';
      this.error = '';

      // Đăng ký thành công điều hướng qua trang home
      this.$router.push('/signin');
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
}

/* Các ô input */
.login-form input {
  width: 100%; /* Đảm bảo các ô input có chiều rộng bằng nhau */
  padding: 12px; /* Đảm bảo padding đồng đều */
  margin: 10px 0; /* Khoảng cách giữa các ô input */
  border: 1px solid #ddd;
  border-radius: 5px;
  box-sizing: border-box; /* Đảm bảo padding được tính vào tổng chiều rộng */
  font-size: 14px; /* Kích thước chữ đồng nhất */
}

/* Nút đăng ký */
.login-form button {
  width: 100%;
  padding: 12px;
  margin: 10px 0;
  background-color: #ff5722;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  box-sizing: border-box; /* Đảm bảo padding được tính vào tổng chiều rộng */
  font-size: 14px;
}

/* Thông báo lỗi */
.error-message {
  color: red;
  font-size: 0.9em;
  margin: 10px 0;
}

/* Phần social-login (Facebook và Google) */
.social-login {
  display: flex;
  justify-content: space-between; /* Đặt chúng nằm ngang */
  margin-top: 10px;
}

.social-login button {
  width: 48%; /* Mỗi nút chiếm khoảng 48% chiều rộng */
  padding: 12px;
  margin: 0; /* Xóa margin giữa các nút */
  border: none;
  border-radius: 5px;
  cursor: pointer;
  font-size: 14px;
}

.social-login button:first-child {
  background-color: #3b5998; /* Facebook màu */
  color: white;
}

.social-login button:last-child {
  background-color: #db4437; /* Google màu */
  color: white;
}

/* Liên kết đăng nhập */
.login-form p {
  margin-top: 20px;
  font-size: 0.9em;
}

.login-form p a {
  color: #ff5722;
  text-decoration: none;
}

</style>
