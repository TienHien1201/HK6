// src/store/mutations.js
export default {
  setProducts(state, products) {
    state.products = products; // Đảm bảo chỉ set dữ liệu một lần
  },
  addProductToState(state, newProduct) {
    state.products.push(newProduct); // Thêm sản phẩm mới vào mảng sản phẩm
  },
  updateProductInState(state, updatedProduct) {
    const index = state.products.findIndex((product) => product.id === updatedProduct.id);
    if (index !== -1) {
      state.products.splice(index, 1, updatedProduct); // Thay thế sản phẩm cũ bằng sản phẩm mới
    }
  },
  removeProductFromState(state, id) {
    state.products = state.products.filter((product) => product.id !== id); // Loại bỏ sản phẩm có ID tương ứng
  },
};
