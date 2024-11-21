<template>
  <div class="containerForm">
    <form action="action_page.php">
      <label for="fname">First Name</label>
      <input type="text" id="fname" name="firstname" placeholder="Your name.." />

      <label for="lname">Last Name</label>
      <input type="text" id="lname" name="lastname" placeholder="Your last name.." />

      <label for="country">Country</label>
      <select id="country" name="country">
        <option value="vietname">Viet Nam</option>
        <option value="canada">Canada</option>
        <option value="usa">USA</option>
      </select>

      <label for="subject">Subject</label>
      <textarea
        id="subject"
        name="subject"
        placeholder="Write something.."
        style="height: 200px"
      ></textarea>

      <input type="submit" value="Submit" />
    </form>
  </div>
</template>

<script>
export default {
  name: 'ComLienHe',
};
</script>

<style>
/* Thêm background và padding cho containerForm */
.containerForm {
    background-image: url('../assets/News/ImgBG.png');
  display: flex; /* Sử dụng flexbox */
  justify-content: center; /* Căn giữa theo chiều ngang */
  align-items: center; /* Căn giữa theo chiều dọc */
  min-height: 100vh; /* Đảm bảo chiều cao tối thiểu để căn giữa */
  background-color: #f2f2f2; /* Màu nền cho container */
}

/* Thay đổi để căn giữa các phần trong form */
form {
  display: flex; /* Sử dụng flexbox cho form */
  flex-direction: column; /* Đặt hướng là cột */
  align-items: center; /* Căn giữa các phần tử trong form */
  width: 100%; /* Chiều rộng 100% */
  max-width: 500px; /* Giới hạn chiều rộng tối đa của form */
}

/* Style inputs with type="text", select elements and textareas */
input[type='text'],
select,
textarea {
  width: 100%; /* Full width */
  padding: 12px; /* Some padding */
  border: 1px solid #ccc; /* Gray border */
  border-radius: 4px; /* Rounded borders */
  box-sizing: border-box; /* Make sure that padding and width stays in place */
  margin-top: 6px; /* Add a top margin */
  margin-bottom: 16px; /* Bottom margin */
  resize: vertical; /* Allow the user to vertically resize the textarea (not horizontally) */
}

/* Style the submit button with a specific background color etc */
input[type='submit'] {
  background-color: #04aa6d;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

/* When moving the mouse over the submit button, add a darker green color */
input[type='submit']:hover {
  background-color: #45a049;
}
</style>
