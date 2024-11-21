<template>
  <header>
    <div class="container">
      <div class="logo">
        <img src="../assets/logo.png" alt="Coffe Logo" />
      </div>
      <nav>
          <img src="images/header-bg.png" alt="header-bg" class="background-image" />
          <ul>
          <li><router-link to="/">Home</router-link></li>
          <li><router-link to="/thucdon">Coffees</router-link></li>
          <li><router-link to="/gioithieu">About</router-link></li>
          <li><router-link to="/lienhe">Contact </router-link></li>
          <li><router-link to="/tintuc">Blog </router-link></li>
        </ul>
      </nav>
      <div class="cta">
        
        <div v-if="user">
        <span class="welcome">Welcome, {{ user.username }}</span>
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
        <router-link to="/cart" class="cta-button">🛒</router-link>
      </div>
    </div>
  </header>
  <!-- lấy nội dung component được link tới thì dùng -->
  <router-view />
</template>

<script>
export default {
  
};
</script>

<style>
.container {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 20px;
  background-color: #d48473;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.logo img {
  height: 50px;
  transition: transform 0.3s ease;
}

/* .logo img:hover {
    transform: scale(1.1);
} */

nav ul {
  list-style: none;
  display: flex;
  margin: 0;
  padding: 0;
}

nav ul li {
  margin: 0 15px;
}

nav ul li a {
  text-decoration: none;
  color: #000;
  font-weight: bold;
  transition: color 0.3s ease;
}

nav ul li a:hover {
  color: #fcb034;
}
.cta-button {
  padding: 10px 20px;
  background-color: white;
  text-decoration: none;
  border-radius: 25px;
  transition: background-color 0.3s ease, transform 0.3s ease;
}

.cta-button:hover {
  background-color: #ffa726;
  transform: scale(1.1);
}
/* Đặt ảnh nền với z-index thấp hơn để các <li> nằm trên */
nav {
  position: relative;
}

ul {
  position: relative;
  list-style: none;
  padding: 0;
  margin: 0;
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 20px;
  z-index: 1; /* Đảm bảo các <li> nằm trên nền */
}

.background-image {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  object-fit: cover;
  z-index: 0; /* Đảm bảo ảnh nền nằm dưới */
}

li {
  font-size: 28px;
  font-weight: bold;
  color: white; /* Tùy chỉnh màu sắc để nổi bật trên nền */
}

li a {
  text-decoration: none;
  color: inherit;
}

li a:hover {
  color: #ff6a00; /* Thay đổi màu khi hover nếu cần */
}
</style>
