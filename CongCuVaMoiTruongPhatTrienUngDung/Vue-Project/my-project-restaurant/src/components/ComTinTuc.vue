<template>
  <div class="container-lienhe">
    <div class="content-wrapper">
      <div class="Product_list_contain">
        <div class="Product_list">
          <img :src="post?.featuredImage" loading="lazy" :alt="post?.title" />
        </div>
        <div class="post_list">
          <span>{{ post?.publishDate }}</span>
          <h2>{{ post?.title }}</h2>
          <p>{{ post?.description }}</p>
          <div>
            <div class="btn_Action">
              <button>Edit</button>
              <button>Delete</button>
            </div>
          </div>
        </div>
      </div>

      <div class="news-list">
        <div class="news-item" v-for="news in newsItems" :key="news.id">
          <img :src="news.image" alt="news image" class="news-image" />
          <h3>{{ news.title }}</h3>
          <p>{{ news.description }}</p>
          <button class="read-more">Đọc Tiếp</button>
        </div>
      </div>

      <ComCRUDProductVue class="product_Crud" />
    </div>
  </div>
</template>

<script>
import ComCRUDProductVue from './ComCRUDProduct.vue';
export default {
  name: 'ComTinTuc',
  data() {
    return {
      post: {
        featuredImage: '',
        title: '',
        publishDate: '',
        description: '',
      },
      newsItems: [
        { id: 1, image: '', title: 'News Title', description: 'News Description' },
        { id: 2, image: '', title: 'Another News', description: 'Another Description' },
      ],
    };
  },
  components: {
    ComCRUDProductVue,
  },
  methods: {
    loadMoreStores() {
      console.log('Load more stores');
    },
  },
};
</script>

<style scoped>
.container-lienhe {
  padding-top: 40px;
  background-image: url('../assets/News/ImgBG.png');
  display: flex;
  justify-content: center;  /* Căn giữa nội dung theo chiều ngang */
  align-items: center;  /* Căn giữa nội dung theo chiều dọc */
  height: 100vh;  /* Đảm bảo container chiếm 100% chiều cao của màn hình */
  padding: 20px;
  flex-direction: column;
}

.content-wrapper {
  width: 100%;
  max-width: 1200px; /* Điều chỉnh theo nhu cầu */
  background-color: rgba(77, 77, 77, 0.678);
  border-radius: 10px;
  padding: 20px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
  display: flex;
  flex-direction: column;
  gap: 20px;
  color: darkgreen;
  align-items: center;  /* Căn giữa các phần tử trong content-wrapper */
}

.Product_list_contain {
  display: flex;
  gap: 20px;
  width: 100%;
  justify-content: center;  /* Căn giữa các phần tử sản phẩm */
  align-items: center;
}

.Product_list img {
  width: 100%;
  height: auto;
  border-radius: 8px;
  object-fit: cover;
}

.post_list {  
  flex: 1;
  display: flex;
  flex-direction: column;
  justify-content: center;  /* Căn giữa nội dung trong post_list */
  align-items: center;
}

.post_list h2 {
  font-size: 1.5rem;
  font-weight: bold;
}

.btn_Action button {
  margin-right: 10px;
}

.news-list {
  display: flex;
  flex-direction: column;
  width: 100%;
  gap: 20px;
}

.news-item {
  display: flex;
  gap: 10px;
  align-items: center;
  background-color: #f9f9f9;
  padding: 15px;
  border-radius: 8px;
  justify-content: center;  /* Căn giữa các phần tử trong mỗi news-item */
}

.news-item img {
  width: 100px;
  height: 100px;
  object-fit: cover;
  border-radius: 8px;
}

.product_Crud {
  width: 100%;
  max-width: 1200px; /* Giới hạn chiều rộng tối đa */
  display: flex;
  justify-content: center;  /* Căn giữa theo chiều ngang */
  align-items: center;  /* Căn giữa theo chiều dọc */
  margin: 0 auto;  /* Căn giữa theo chiều ngang */
  padding: 20px;  /* Khoảng cách bên trong */
}

</style>
