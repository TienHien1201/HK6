<template>
  <footer>
    <div class="footer-container">
      <div class="footer-column">
        <img src="../assets/News/ImgBG.png" alt="Logo" class="logo">
        <h3>Về chúng tôi</h3>
        <p>ABC – HÀNH TRÌNH CHINH PHỤC PHONG VỊ MỚI. ABC không ngừng theo đuổi sứ mệnh mang phong vị mới từ những vùng đất trứ danh tại Việt Nam và trên thế giới đến khách hàng.</p>
      </div>

      <div class="footer-column">
        <h3>Liên Hệ</h3>
        <p>Phạm Tiến Hiền</p> 
        <p>MSSV 22150319</p>       
        <p>Lớp 221405</p>       
        <p><i class="fa fa-envelope"></i> Email: <a href="mailto:tienhien.cnnt@gmail.com">cnnt@gmail.com</a></p>
        <p><i class="fa fa-map-marker"></i> Representative Store: 91 Đồng Khởi, Quận 1, TP Hồ Chí Minh</p>
        <p><i class="fa fa-map-marker"></i> Working Office: 96-98-100 Trần Nguyên Đán, Quận Bình Thạnh, TP Hồ Chí Minh</p>
        <p><i class="fa fa-phone"></i> Customer Service: (028) 7300 1009</p>
      </div>

      <div class="footer-column">
        <h3>Hỗ Trợ và Chính Sách</h3>
        <ul>
          <li>Quy chế hoạt động và Chính sách bảo mật</li>
          <li>Chính sách vận chuyển</li>
          <li>Chính sách thanh toán</li>
        </ul>
      </div>

      <div class="footer-qr">
        <img style="width: 40px; height: 40px;" src="../assets/QR.jpg" alt="QR Code" class="qr-code">
        <img src="../assets/News/Logo.svg" alt="App Mockup" class="app-mockup">
      </div>
    </div>

    <div class="footer-bottom">
      <div class="footer-social">
        <a href="#"><img src="../assets/News/zalo.png" alt="Zalo"></a>
        <a href="#"><img src="../assets/News/FB.png" alt="Facebook"></a>
        <a href="#"><img src="../assets/News/IG.png" alt="Instagram"></a>
      </div>
      <p>©ABC Saigon Kafé 2022 | All rights reserved. Website by ABC.</p>
    </div>
  </footer>
</template>

<script>
export default {};
</script>

<style>
footer {
  background-color: 
#b6832c;
  color: white;
  padding: 40px 20px;
  font-family: Arial, sans-serif;
}

.footer-container {
  display: flex;
  justify-content: space-between;
  max-width: 1200px;
  margin: 0 auto;
  flex-wrap: wrap;
  position: relative;
}

.footer-column {
  flex: 1;
  min-width: 200px;
  padding: 10px;
}

.footer-column h3 {
  font-size: 18px;
  font-weight: bold;
  color: #d7a461;
}

.footer-column p, .footer-column ul {
  color: #b0b0b0;
  font-size: 14px;
}

.footer-column ul {
  list-style: none;
  padding: 0;
}

.footer-column ul li {
  margin-bottom: 5px;
}

.footer-column a {
  color: #b0b0b0;
  text-decoration: none;
}

.footer-column a:hover {
  color: #d7a461;
}

.logo {
  max-width: 150px;
  margin-bottom: 10px;
}

.footer-qr {
  position: absolute;
  top: 10px;
  right: 0;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.qr-code, .app-mockup {
  max-width: 100px;
  margin: 10px 0;
}

.footer-bottom {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-top: 20px;
  border-top: 1px solid #555;
  padding-top: 10px;
}

.footer-social {
  display: flex;
  gap: 10px;
}

.footer-social img {
  width: 30px;
  height: 30px;
  transition: transform 0.3s;
}

.footer-social img:hover {
  transform: scale(1.1);
}

.footer-bottom p {
  font-size: 12px;
  color: #b0b0b0;
  margin: 0;
}
</style>
