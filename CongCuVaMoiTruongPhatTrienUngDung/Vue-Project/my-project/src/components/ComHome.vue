<template>
  <!-- 
    <h1>TẤT CẢ SẢN PHẨM</h1>
    <Product v-for="item in products" :key="item.id" :product="item"/> -->
  <!-- banner section start -->

  <div class="banner_section layout_padding">
    <div class="container">
      <div id="banner_slider" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner">
          <transition-group name="slide" tag="div" class="carousel-container">
            <div
              v-for="(item, index) in activeBanner"
              :key="index"
              class="carousel-item active"
              style="width: 100%"
            >
              <div class="row">
                <div class="col-md-6">
                  <div class="banner_img">
                    <img class="Image_BannerBg" src="images/banner-bg.png" alt="" />
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="banner_taital_main">
                    <img :src="item.image" alt="Banner Image" />
                    <h1 class="banner_taital">{{ item.bannertitle }}</h1>
                    <h5 class="tasty_text">{{ item.tastytext }}</h5>
                    <p class="banner_text">{{ item.bannertext }}</p>
                    <div class="btn_main">
                      <div class="about_bt">
                        <a href="#">{{ item.about }}</a>
                      </div>
                      <div class="callnow_bt active">
                        <a href="#">{{ item.callnow }}</a>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </transition-group>
        </div>
      </div>
    </div>
  </div>
  <!-- banner section end -->

  <!-- header section end -->
  <!-- coffee section start -->
  <div class="coffee_section layout_padding">
    <div class="container">
      <div class="row">
        <h1 class="coffee_taital">OUR Coffee OFFER</h1>
        <div class="bulit_icon"><img src="images/bulit-icon.png" /></div>
      </div>
    </div>
    <div class="coffee_section_2" id="app">
      <div id="main_slider" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner">
          <div class="carousel-item active">
            <div class="container-fluid">
              <div class="row coffee-items">
                <div class="col-lg-3 col-md-6" v-for="(item, index) in coffeeItems" :key="index">
                  <div class="coffee_img"><img :src="item.image" /></div>
                  <h3 class="types_text">{{ item.title }}</h3>
                  <p class="looking_text">{{ item.description }}</p>
                  <div class="read_bt">
                    <a href="#">{{ item.linkText }}</a>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- Có thể thêm nhiều carousel-item khác nếu cần -->
        </div>
        <a class="carousel-control-prev" href="#main_slider" role="button" data-slide="prev">
          <i class="fa fa-arrow-left"></i>
        </a>
        <a class="carousel-control-next" href="#main_slider" role="button" data-slide="next">
          <i class="fa fa-arrow-right"></i>
        </a>
      </div>
    </div>
  </div>
  <!-- coffee section end -->
  <!-- about section start -->
  <div class="about_section layout_padding">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h1 class="about_taital">About Our shop</h1>
          <div class="bulit_icon"><img src="images/bulit-icon.png" /></div>
        </div>
      </div>
      <div class="about_section_2 layout_padding">
        <div class="image_iman"><img src="images/about-img.png" class="about_img" /></div>
        <div class="about_taital_box">
          <h1 class="about_taital_1">Coffee distribution '</h1>
          <p class="about_text">
            has a more-or-less normal distribution of letters, as opposed to using 'Content here,
            content here', making it look like readable English. Many desktop publishing packages
            and web page editorhas a more-or-less normal distribution of letters, as opposed to
            using 'Content here, content here', making it look like readable English. Many desktop
            publishing packages and web page editor
          </p>
          <div class="readmore_btn"><a href="#">Read More</a></div>
        </div>
      </div>
    </div>
  </div>
  <!-- about section end -->
  <!-- client section start -->
  <div class="client_section layout_padding">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h1 class="about_taital">What syas customers</h1>
          <div class="bulit_icon"><img src="images/bulit-icon.png" /></div>
        </div>
      </div>
      <div class="client_section_2">
        <div class="client_taital_main">
          <div class="client_left">
            <div class="client_img"><img src="images/client-img1.png" /></div>
          </div>
          <div class="client_right">
            <h3 class="moark_text">Joy Moark</h3>
            <p class="client_text">
              now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will
              uncover many web sites still in their infancynow use Lorem Ipsum as their default
              model text,
            </p>
          </div>
        </div>
        <div class="client_taital_main">
          <div class="client_left">
            <div class="client_img"><img src="images/client-img2.png" /></div>
          </div>
          <div class="client_right">
            <h3 class="moark_text">Mihacal</h3>
            <p class="client_text">
              now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will
              uncover many web sites still in their infancynow use Lorem Ipsum as their default
              model text,
            </p>
          </div>
        </div>
        <div class="client_taital_main">
          <div class="client_left">
            <div class="client_img"><img src="images/client-img3.png" /></div>
          </div>
          <div class="client_right">
            <h3 class="moark_text">Uliya den</h3>
            <p class="client_text">
              now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will
              uncover many web sites still in their infancynow use Lorem Ipsum as their default
              model text,
            </p>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- client section end -->
  <!-- blog section start -->
  <div class="blog_section layout_padding">
    <div class="row">
      <div class="col-md-12">
        <h1 class="about_taital_Blog">Our Blog</h1>
        <div class="bulit_icon_Blog"><img src="images/bulit-icon.png" /></div>
      </div>
    </div>
    <div class="container">
      <div class="blog_section_2">
        <div class="row blog-items">
          <div class="col-md-6" v-for="blog in blogData" :key="blog.id">
            <div class="blog_box">
              <div class="blog_img"><img :src="blog.imgSrc" /></div>
              <h4 class="date_text">{{ blog.date }}</h4>
              <h4 class="prep_text">{{ blog.title }}</h4>
              <p class="lorem_text">{{ blog.description }}</p>
              <div class="read_bt"><a href="#">Read More</a></div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- blog section end -->
  <!-- contact section start -->
  <div class="contact_section layout_padding">
    <div class="row">
      <div class="col-sm-12">
        <h1 class="contact_taital">Get In Touch</h1>
        <div class="bulit_icon"><img src="images/bulit-icon.png" /></div>
      </div>
    </div>

    <div class="container-fluid">
      <div class="contact_section_2">
        <div class="row">
          <div class="col-md-12">
            <div class="mail_section_1">
              <input type="text" class="mail_text" placeholder="Your Name" name="Your Name" />
              <input type="text" class="mail_text" placeholder="Your Email" name="Your Email" />
              <input type="text" class="mail_text" placeholder="Your Phone" name="Your Phone" />
              <textarea
                class="massage-bt"
                placeholder="Massage"
                rows="5"
                id="comment"
                name="Massage"
              ></textarea>
              <div class="send_bt"><a href="#">SEND</a></div>
            </div>
          </div>
          <div class="map_main">
            <div class="map-responsive">
              <iframe
                src="https://www.google.com/maps/embed/v1/place?key=AIzaSyA0s1a7phLN0iaD6-UE7m4qP-z21pH0eSc&amp;q=Eiffel+Tower+Paris+France"
                width="250"
                height="500"
                frameborder="0"
                style="border: 0; width: 100%"
                allowfullscreen=""
              ></iframe>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
// import Product from './ComProduct.vue'
import banners from '@/data/slideData';
import coffeeItems from '@/data/coffeeItems';
import blogData from '@/data/CoffeeBlogs';

export default {
  data() {
    return {
      banners,
      coffeeItems,
      blogData,
      currentBannerIndex: 0,
    };
  },
  computed: {
    activeBanner() {
      // Return the currently active banner as an array for use in the v-for directive
      return [this.banners[this.currentBannerIndex]];
    },
  },
  mounted() {
    this.startBannerSlideshow();
  },
  methods: {
    startBannerSlideshow() {
      setInterval(() => {
        this.currentBannerIndex = (this.currentBannerIndex + 1) % this.banners.length;
      }, 3000); // Tự động chuyển ảnh mỗi 3 giây
    },
    prevSlide() {
      this.currentBannerIndex =
        (this.currentBannerIndex - 1 + this.banners.length) % this.banners.length;
    },
    nextSlide() {
      this.currentBannerIndex = (this.currentBannerIndex + 1) % this.banners.length;
    },
  },
};
</script>
<style>
.layout_padding {
  padding: 60px 0;
}

h1 {
  font-size: 36px;
  color: #333;
  font-weight: bold;
  margin-bottom: 20px;
}

h1.about_taital {
  font-size: 28px;
  color: #333;
  text-align: center; /* Căn giữa tiêu đề */
  font-weight: bold;
  margin-bottom: 10px;
}

/* Định dạng cho các section hình ảnh sản phẩm (coffee_section) */
.coffee_section {
  background-color: #f8f9fa;
  padding: 60px 0;
}

.coffee_section .container {
  display: flex; /* Sử dụng flexbox */
  flex-direction: column; /* Sắp xếp theo chiều dọc */
  align-items: center; /* Căn giữa theo chiều ngang */
  text-align: center; /* Căn giữa nội dung */
}

.coffee_section .bulit_icon {
  display: inline-block; /* Đảm bảo rằng biểu tượng được căn giữa */
  margin-top: 10px; /* Khoảng cách phía trên biểu tượng */
}

/* Các phần khác giữ nguyên */

.coffee_section_2 {
  background-color: #f8f9fa; /* Định dạng nền cho phần coffee */
}

.coffee-items {
  display: flex; /* Sử dụng flexbox để các mục nằm ngang */
  justify-content: space-between; /* Căn chỉnh khoảng cách giữa các mục */
  flex-wrap: wrap; /* Cho phép wrap nếu màn hình nhỏ */
}

/* Thay đổi kích thước và bố cục cho các mục coffee */
.coffee_img {
  text-align: center;
  margin-bottom: 15px;
}

.types_text {
  font-size: 20px;
  color: #333;
  text-align: center;
  font-weight: bold;
  margin-top: 10px;
}

.looking_text {
  font-size: 14px;
  color: #666;
  text-align: center;
  margin-top: 5px;
}

.read_bt a {
  display: inline-block;
  color: #fff;
  background-color: #333;
  padding: 10px 20px;
  text-align: center;
  margin-top: 10px;
  text-decoration: none;
  border-radius: 5px;
}

.read_bt a:hover {
  background-color: #555;
}

/* Định dạng cho blog section */
.blog_section {
  padding: 60px 0; /* Thêm padding cho phần blog */
}

.blog_section_2 {
  background-color: #f8f9fa; /* Định dạng nền cho phần blog */
  text-align: center; /* Căn giữa tiêu đề và biểu tượng */
}

.about_taital_Blog {
  font-size: 28px;
  color: #333;
  font-weight: bold;
  margin-bottom: 10px;
}

.bulit_icon_Blog {
  display: inline-block; /* Đảm bảo rằng biểu tượng được căn giữa */
  margin-top: 10px; /* Khoảng cách phía trên biểu tượng */
}

.blog-items {
  display: flex; /* Sử dụng flexbox để các mục blog nằm ngang */
  justify-content: space-between; /* Căn chỉnh khoảng cách giữa các mục */
  flex-wrap: wrap; /* Cho phép wrap nếu màn hình nhỏ */
}

.blog_box {
  margin-bottom: 30px;
  padding: 20px;
  background-color: #f8f9fa;
  border-radius: 5px;
  flex: 0 0 48%; /* Chiều rộng 48% cho 2 cột */
  max-width: 48%; /* Giới hạn chiều rộng tối đa */
}

.blog_img img {
  width: 100%;
  border-radius: 5px;
}

.date_text,
.prep_text {
  font-size: 14px;
  color: #333;
  margin-top: 10px;
  font-weight: bold;
}

.lorem_text {
  font-size: 14px;
  color: #666;
  margin-top: 10px;
}

/* Định dạng contact section */
.contact_section .mail_text {
  width: 100%;
  padding: 15px;
  margin-bottom: 15px;
  border: 1px solid #ddd;
  border-radius: 5px;
}

.massage-bt {
  width: 100%;
  padding: 15px;
  border: 1px solid #ddd;
  border-radius: 5px;
  margin-bottom: 15px;
}

.send_bt a {
  display: inline-block;
  padding: 10px 20px;
  color: #fff;
  background-color: #333;
  text-decoration: none;
  border-radius: 5px;
}

.send_bt a:hover {
  background-color: #555;
}

/* Định dạng cho carousel */
.carousel-inner .carousel-item {
  display: none;
}

.carousel-inner .carousel-item.active {
  display: block;
}

.banner_section .carousel-inner {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
}

.banner_section .carousel-container {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
}

.banner_section .carousel-item {
  display: flex;
  justify-content: center;
  align-items: center;
  text-align: center;
  width: 100%;
  height: 100%;
}

.banner_section .row {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
}

.banner_section .banner_img img {
  max-width: 100%;
  height: auto;
}

.banner_section .btn_main {
  display: flex;
  justify-content: center;
  gap: 15px;
}

/* Cài đặt cho tối đa 4 mục coffee-items nằm ngang */
.coffee_section_2 .coffee-items .col-lg-3 {
  flex: 0 0 24%; /* Chiều rộng 24% cho 4 cột */
  max-width: 24%; /* Giới hạn chiều rộng tối đa */
}

/* Cài đặt cho tối đa 2 mục blog-items nằm ngang */
.blog_section_2 .blog-items .col-md-6 {
  flex: 0 0 48%; /* Chiều rộng 48% cho 2 cột */
  max-width: 48%; /* Giới hạn chiều rộng tối đa */
}

/* Định dạng cho phần client_section */
.client_section {
  padding: 60px 0; /* Thêm padding cho phần client */
}

.client_section .container {
  display: flex; /* Sử dụng flexbox để căn giữa phần tử */
  flex-direction: column; /* Sắp xếp theo chiều dọc */
  align-items: center; /* Căn giữa theo chiều ngang */
  text-align: center; /* Căn giữa nội dung */
}

.client_taital_main {
  display: flex; /* Sử dụng flexbox để căn chỉnh bên trái */
  align-items: center; /* Căn giữa theo chiều dọc */
  margin-bottom: 30px; /* Khoảng cách giữa các phần tử */
}

.client_left {
  margin-right: 40px; /* Khoảng cách 40px giữa hình ảnh và text */
}

.client_img img {
  max-width: 100%; /* Đảm bảo hình ảnh không vượt quá chiều rộng của phần tử */
  height: auto; /* Giữ tỉ lệ chiều cao */
}

.moark_text {
  font-size: 18px; /* Kích thước font cho tên khách hàng */
  font-weight: bold; /* Đậm */
  color: #333; /* Màu chữ */
  margin-bottom: 5px; /* Khoảng cách dưới */
}

.client_text {
  font-size: 14px; /* Kích thước font cho nội dung */
  color: #666; /* Màu chữ */
}

/* Định dạng cho phần client_section_2 */
.client_section_2 {
  width: 100%; /* Đảm bảo rằng phần này chiếm toàn bộ chiều rộng */
}

/* Định dạng cho biểu tượng bulit_icon */
.client_section .bulit_icon {
  display: inline-block; /* Đảm bảo biểu tượng được căn giữa */
  margin-top: 10px; /* Khoảng cách phía trên biểu tượng */
  text-align: center; /* Căn giữa nội dung bên trong biểu tượng */
}

/* Định dạng cho phần about_section */
.about_section {
  padding: 60px 0; /* Thêm padding cho phần about */
}

.about_section .container {
  display: flex; /* Sử dụng flexbox để căn giữa phần tử */
  flex-direction: column; /* Sắp xếp theo chiều dọc */
  align-items: center; /* Căn giữa theo chiều ngang */
  text-align: center; /* Căn giữa nội dung */
}

.about_section_2 {
  display: flex; /* Sử dụng flexbox để căn giữa phần hình ảnh và nội dung */
  justify-content: center; /* Căn giữa theo chiều ngang */
  align-items: center; /* Căn giữa theo chiều dọc */
}

.image_iman {
  margin-right: 20px; /* Khoảng cách giữa hình ảnh và nội dung */
}

.about_taital_1 {
  font-size: 24px;
  font-weight: bold;
  color: #333;
  margin-top: 20px; /* Khoảng cách phía trên tiêu đề */
}

.about_text {
  font-size: 16px;
  color: #666;
  margin-top: 10px; /* Khoảng cách phía trên văn bản */
}

.readmore_btn {
  margin-top: 15px; /* Khoảng cách phía trên nút đọc thêm */
}

/* Định dạng cho các phần tử không được dùng */
.client_section .bulit_icon {
  text-align: left; /* Căn trái cho biểu tượng */
}
</style>
