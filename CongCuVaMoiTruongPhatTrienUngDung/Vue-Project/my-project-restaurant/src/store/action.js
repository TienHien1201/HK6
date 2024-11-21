import axios from 'axios';
import APIURL from '../constraint';

export default {
  async fetchProducts({ commit, state }) {
    // Kiểm tra nếu dữ liệu đã được fetch rồi, không gọi lại API nữa
    if (state.products.length > 0) {
      return; // Dữ liệu đã có, không làm gì cả
    }
    try {
      // Sử dụng axios để gọi API
      const response = await axios.get(`${APIURL}productDrink`);
      console.log(response.data);
      commit('setProducts', response.data); // Gọi mutation để cập nhật state
    } catch (error) {
      console.error('Error fetching products:', error);
    }
  },
  async addProduct({ commit }, newProduct) {
    try {
      // Gửi yêu cầu POST tới API để thêm sản phẩm mới
      const response = await axios.post(`${APIURL}productDrink`, newProduct);
      // Gọi mutation để thêm sản phẩm mới vào state
      commit('addProductToState', response.data);
    } catch (error) {
      console.error('Error adding product:', error);
    }
  },
  async updateProduct({ commit }, { id, updatedProduct }) {
    try {
      // Gọi API PUT để cập nhật sản phẩm
      const response = await axios.put(`${APIURL}productDrink/${id}`, updatedProduct);
      // Gọi mutation để cập nhật sản phẩm trong state
      commit('updateProductInState', response.data);
    } catch (error) {
      console.error('Error updating product:', error);
    }
  },
  async deleteProduct({ commit }, id) {
    try {
      // Gọi API DELETE để xóa sản phẩm
      await axios.delete(`${APIURL}productDrink/${id}`);
      // Gọi mutation để xóa sản phẩm khỏi state
      commit('removeProductFromState', id);
    } catch (error) {
      console.error('Error deleting product:', error);
    }
  },  
};
