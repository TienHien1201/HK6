<template>
  <div class="w3-container" id="about">
    <div class="w3-content" style="max-width: 700px">
      <h5 class="w3-center w3-padding-64">
        <span class="w3-tag w3-wide">ABOUT THE CAFE</span>
      </h5>
      <p>
        The Cafe was founded in blabla by Mr. Smith in lorem ipsum dolor sit amet, consectetur
        adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim
        ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
        consequat.
      </p>
      <p>
        In addition to our full espresso and brew bar menu, we serve fresh made-to-order breakfast
        and lunch sandwiches, as well as a selection of sides and salads and other good stuff.
      </p>
      <div class="w3-panel w3-leftbar w3-light-grey">
        <p>
          <i
            >"Use products from nature for what it's worth - but never too early, nor too late."
            Fresh is the new sweet.</i
          >
        </p>
        <p>Chef, Coffeeist and Owner: Liam Brown</p>
      </div>
      <img
        src="@/assets/HomeImg/coffeeshop.png"
        style="width: 100%; max-width: 1000px"
        class="w3-margin-top"
      />
      <p><strong>Opening hours:</strong> everyday from 6am to 5pm.</p>
      <p>
        <strong>Address:</strong> Nguyen Xien street, District 9 , Thu Duc city - Ho CHi Minh City
      </p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ComGioiThieu',
};
</script>

<style>
.w3-container {

  display: flex; /* Sử dụng flexbox để căn giữa nội dung */
  justify-content: center; /* Căn giữa theo chiều ngang */
  align-items: center; /* Căn giữa theo chiều dọc */
  height: 100vh; /* Chiều cao của container bằng 100% chiều cao của cửa sổ */
  padding-top: 60px;
  background-color: #f1e3b9fc;
  color: #093d44;
  text-align: center; /* Căn giữa văn bản */
}

.w3-content {
  width: 100%;
  max-width: 700px; /* Đảm bảo độ rộng tối đa của nội dung */
  padding: 20px;
}

.w3-center {
  text-align: center; /* Căn giữa các phần tử nội dung */
}

.w3-panel {
  margin: 20px 0; /* Thêm margin giữa các panel */
}

.w3-panel p {
  margin: 10px 0; /* Căn chỉnh khoảng cách giữa các đoạn văn */
}

img {
  width: 100%;
  max-width: 1000px;
  margin-top: 20px;
  border-radius: 8px; /* Thêm border-radius để làm mềm các góc của ảnh */
}
</style>
