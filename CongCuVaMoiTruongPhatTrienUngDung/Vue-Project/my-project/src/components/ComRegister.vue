<template>
  <div>
    <h2>Đăng ký tài khoản</h2>
    <input  v-model="username" placeholder="Tên đăng nhập" />
    <input  v-model="password" type="password" placeholder="Mật khẩu" />
    <input
      v-model="confirmPassword"
      type="password"
      placeholder="Xác nhận mật khẩu"
    />
    <button @click="register">Đăng ký</button>
    <p v-if="error" class="error">báo lỗi</p>
    <!-- <p  class="success">báo thành công</p> -->
  </div>
</template>

<script>
import users from '@/data/users'
export default {
  data() {
    return {
      username: "",
      password: "",
      confirmPassword: "",
      error: "",
      success: "",
      users:users
     
    };
  },
  methods:{
    register()
    {
      // kiem tra mta khau va nhap lai mat khau phai trung voi nhau
      if(this.password!==this.confirmPassword)
    {
      this.error="Mật khẩu không trùng"
      return
    }
    // kiem tra xem duoi localstorage co luu lai users hay khong
    const users=JSON.parse(localStorage.getItem('users'))||[]
    //Kiem tra ten co ton tai hay khong
    const exituser=this.users.find(x=>x.username==this.username)
    if(exituser)
    {
      this.error="Tên đã tồn tại"
      return
    }
    // tao 1 doi tuong
    const newuser={id:this.users.length+1,username:this.username,password:this.password}
    this.users.push(newuser)
    // luu vao localStorage
    localStorage.setItem('users',JSON.stringify(users))
    alert('Đăng kí thành công')
    this.username=''
    this.password=''
    this.confirmPassword=''
    this.error=''
    //dang ki thanh cong dieu huong qua trang login:this.$router.push(path)
    this.$router.push('/login')
    }
  }
  
};
</script>

<style>
</style>