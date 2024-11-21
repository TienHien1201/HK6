<template>
  <div>
    <h1>All Product</h1>
    <div class="product-grid">
      <Product v-for="item in products" :key="item.id" :product="item" />
    </div>
  </div>
</template>

<script>
import Product from './ComProduct.vue';
import coffeeItems from '@/data/coffeeItems';
export default {
  name: 'ComThucDon',
  components: {
    Product,
  },
  data() {
    return {
      products: coffeeItems,
    };
  },
};
</script>

<style>
.product-grid {
  display: grid;
  grid-template-columns: repeat(5, 1fr); /* Đổi thành 4 cột để hình ảnh rộng hơn */
  gap: 5px;
}

.product-grid > * {
  align-self: center;
  width: 150%;
}

.menu-item img {
  

  object-fit: cover; /* Đảm bảo hình ảnh giữ tỷ lệ đẹp mà không bị méo */
}

.menu-item-info {
  padding: 5px; /* Tăng khoảng cách thông tin sản phẩm */
  opacity: 0;
  transition: opacity 0.3s ease;
}

.menu-item:hover .menu-item-info {
  opacity: 1;
}

.menu-item:hover img {
  transform: scale(1.05);
}
</style>
