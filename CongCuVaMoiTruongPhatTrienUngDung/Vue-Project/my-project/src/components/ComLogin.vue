<template>
  <div>
    <h2>Đăng nhập</h2>
    <input v-model ="username" placeholder="Tên đăng nhập" />
    <input v-model ="password" type="password" placeholder="Mật khẩu" />
    <button @click="login" >Đăng nhập</button>
    <p v-if="error" >{{error}}</p>
  </div>
</template>

<script>
import users from '@/data/users'
export default {
  data() {
    return {
      username: '',//an
      password: '',//1234
      error: '',
      users:users
    };
  },
  methods:{
    login()
    {
      const user=this.users.find(x=>x.username===this.username&&x.password===this.password)
      if(user)
    {
      // co thi luu thong tin vua dang nhap vao localStorage
      localStorage.setItem('currentUser',JSON.stringify(user))
      this.$router.push('/')
    }
    else
    {
      this.error="Tên đăng nhập không đúng "
      return
    }
    }
  }
 
};
</script>
