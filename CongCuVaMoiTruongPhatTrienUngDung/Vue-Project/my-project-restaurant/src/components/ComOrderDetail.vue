<template>
  <div>
    <div v-if="cartOrder.length === 0" class="title-empty" style="font-size: 50px">
      Hóa đơn trống
    </div>
    <div class="info-order" v-else>
      <h2>THÔNG TIN HÓA ĐƠN</h2>
      <table style="width: 100%">
        <thead>
          <tr>
            <th>THỜI GIAN THỰC HIỆN THANH TOÁN</th>
            <th>TÊN NGƯỜI ĐẶT</th>
            <th>CHI TIẾT SẢN PHẨM</th>
            <th>PHƯƠNG THỨC THANH TOÁN</th>
            <th>ĐỊA CHỈ NHẬN HÀNG</th>
            <th>TỔNG TIỀN HÓA ĐƠN</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(order, index) in cartOrder" :key="index">
            <td>{{ order.dateOrder }}</td>
            <td>{{ order.name }}</td>
            <td>
              <div v-for="(item, i) in order.details" :key="i">
                <img :src="item.image" style="height: 100px; width: 100px" />
                <div>{{ item.quantity }} x {{ item.name }}</div>
                <div>{{ item.selectedSize }}</div>
                <div>{{ item.selectedPrice }}</div>
              </div>
            </td>
            <td>{{ order.paymentMethod }}</td>
            <td>{{ order.address }}</td>
            <td>{{ order.totalPrice }} VNĐ</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      cartOrder: [], // Dữ liệu hóa đơn hiển thị
    };
  },
  async created() {
    try {
      // Lấy thông tin người dùng hiện tại từ localStorage
      const user = JSON.parse(localStorage.getItem('userCurrent'));

      if (user && user.username) {
        // Gọi API để lấy danh sách hóa đơn
        const orderHistoryResponse = await axios.get(
          'http://localhost:3000/orderHistory'
        );

        // Lọc hóa đơn của người dùng hiện tại
        const userOrders = orderHistoryResponse.data.filter(
          (order) => order.name === user.username
        );

        // Gán danh sách hóa đơn vào biến
        this.cartOrder = userOrders;
      } else {
        console.error('Không tìm thấy thông tin người dùng');
      }
    } catch (error) {
      console.error('Lỗi khi lấy dữ liệu hóa đơn:', error);
    }
  },
};
</script>

<style>
.title-empty {
  padding-top: 50px;
}

.info-order {
  padding-top: 50px;
}

table {
  width: 100%;
  border-collapse: collapse; /* Để loại bỏ khoảng cách giữa các ô */
}

th,
td {
  padding: 10px;
  border: 1px solid #b6832c; /* Đường viền cho các ô */
  text-align: left; /* Canh trái cho văn bản */
}

th {
  background-color: #f2f2f2; /* Màu nền cho tiêu đề cột */
  font-weight: bold;
}

tbody tr:nth-child(even) {
  background-color: #f9f9f9; /* Màu nền khác cho các hàng chẵn */
}
</style>
