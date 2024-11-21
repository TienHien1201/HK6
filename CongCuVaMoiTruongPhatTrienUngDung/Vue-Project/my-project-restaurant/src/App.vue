<template>
  <Header />

  <Footer />
</template>

<script>
// b1: import vào

import Header from './components/ComHeader.vue';

import Footer from './components/ComFooter.vue';
export default {
  name: 'App',
  components: {
    Header,
    Footer,
  },
};
</script>

<style>
#app {
  text-align: center;

  margin-top: 60px;
}
</style>
