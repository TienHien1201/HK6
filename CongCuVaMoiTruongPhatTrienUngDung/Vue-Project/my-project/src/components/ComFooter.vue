<template>
  <footer>
    <div class="footer_section layout_padding">
      <div class="container">
        <img src="images/header-bg.png" alt="header-bg" class="background-image-footer_1" />
        <div class="row">
          <div class="col-md-12">
            <h1 class="address_text">Address</h1>
            <p class="footer_text">
              here, content here', making it look like readable English. Many desktop publishing
              packages and web page editors now use
            </p>
            <div class="location_text">
              <ul>
                <li>
                  <a href="#">
                    <i class="fa fa-phone" aria-hidden="true"></i
                    ><span class="padding_left_10">+01 1234567890</span>
                  </a>
                </li>
                <li>
                  <a href="#">
                    <i class="fa fa-envelope" aria-hidden="true"></i
                    ><span class="padding_left_10">demo@gmail.com</span>
                  </a>
                </li>
              </ul>
            </div>
            <div class="form-group">
              <textarea
                class="update_mail"
                placeholder="Your Email"
                rows="5"
                id="comment"
                name="Your Email"
              ></textarea>
              <div class="subscribe_bt">
                <a href="#"><img src="images/teligram-icon.png" /></a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- footer section end -->
    <!-- copyright section start -->
    <div class="copyright_section">
      <div class="container">
        <img src="images/header-bg.png" alt="header-bg" class="background-image-footer" />
        <div class="row">
          <div class="col-lg-6 col-sm-12">
            <p class="copyright_text">
              2020 All Rights Reserved. Design by
              <a href="https://html.design">Free Html Templates</a>
            </p>
          </div>
          <div class="col-lg-6 col-sm-12">
            <div class="footer_social_icon">
              <ul>
                <li>
                  <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
                </li>
                <li>
                  <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
                </li>
                <li>
                  <a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a>
                </li>
                <li>
                  <a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </footer>
</template>

<script>
export default {};
</script>

<style>
.footer_section {
  padding: 50px 0;
  background-color: #504e4e62;
  color: white;
  text-align: center;
}

.address_text {
  font-size: 24px;
  font-weight: bold;
  color: rgb(0, 255, 64);
  margin-bottom: 15px;
}

.footer_text {
  font-size: 16px;
  color: white;
  margin-bottom: 25px;
}

.location_text ul {
  list-style: none;
  padding: 0;
  margin: 0;
  font-size: 16px;
  color: white;
}

.location_text ul li {
  margin-bottom: 10px;
}

.location_text ul li a {
  color: white;
  text-decoration: none;
}

.location_text ul li a i {
  color: #ff6a00;
}

.padding_left_10 {
  padding-left: 10px;
}

.form-group {
  position: relative;
  display: flex;
  justify-content: center;
  align-items: center;
}

.update_mail {
  width: 300px;
  padding: 10px;
  font-size: 16px;
  border: none;
  border-radius: 5px;
  color: #333;
}

.subscribe_bt {
  position: absolute;
  right: -40px;
}

.subscribe_bt a img {
  width: 35px;
  height: 35px;
}

.copyright_section {
  position: relative;
  background-color: #e87361;
  padding: 30px 0;
  color: white;
  text-align: center;
}

.background-image-footer {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  object-fit: cover;
  z-index: 0;
  opacity: 0.5; /* Điều chỉnh độ mờ của nền nếu cần */
}

.background-image-footer_1 {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  object-fit: cover;
  z-index: 0; /* Nằm dưới nội dung */
  opacity: 0.3; /* Điều chỉnh độ mờ của nền */
}

.container {
  position: relative;
  z-index: 1;
}

.row {
  position: relative;
  z-index: 2; /* Đảm bảo nội dung .row đè lên background */
  color: white;
}

.copyright_text {
  position: relative;
  z-index: 1; /* Đặt z-index cao hơn nền */
  font-size: 16px;
  font-weight: bold;
  color: #fff;
  margin: 0 auto;
  padding-top: 15px;
}

.footer_social_icon {
  position: relative;
  z-index: 1; /* Đảm bảo các icon nằm trên nền */
}

.footer_social_icon ul {
  list-style: none;
  padding: 0;
  margin: 0;
  display: flex;
  justify-content: center;
  gap: 20px;
}

.footer_social_icon ul li a {
  color: #fff;
  font-size: 20px;
}

.footer_social_icon ul li a:hover {
  color: #ff6a00; /* Màu khi hover */
}

</style>
