<template>
  <div v-if="this.cart.length == 0">
    <p>Giỏ hàng trống</p>
  </div>
  <div class="modal-content" style="display: flex">
    <div class="cart-items" style="flex: 0 0 70%; margin-right: 20px">
      <h3>Thông tin sản phẩm trong giỏ hàng</h3>
      <table style="width: 100%" class="text-center table">
        <tr>
          <th>HÌNH</th>
          <th>SẢN PHẨM</th>
          <th>Đơn giá</th>
          <th>Số lượng</th>
          <th>Tiền</th>
          <th></th>
        </tr>
        <!-- dùng v-for thể hiện giỏ hàng -->
        <tr v-for="item in cart" :key="item.id">
          <td><img :src="item.image" style="height: 100px; width: 100px" /></td>
          <td class="align-middle">{{ item.name }}</td>
          <td class="align-middle">{{ item.price }}</td>

          <button @click="decreaseQuantity(item)">-</button>
          {{
            item.quantity
          }}
          <button @click="increaseQuantity(item)">+</button>

          <td class="align-middle">{{ item.price * item.quantity }}</td>
          <td class="align-middle">
            <button class="btn btn-danger" @click="deleteproduct(item)">Remove 1</button>
          </td>
        </tr>
        <tr>
          <th></th>
          <th></th>
          <th>Tổng tiền:{{ tongtien }}</th>
          <th>tính tổng so luong : {{ tongsoluong }}</th>
          <th>tong tien</th>
          <th><button class="btn btn-danger">Xóa hết : !</button></th>
        </tr>
      </table>
    </div>
    <div class="order-info" style="flex: 1">
      <h3>Thông tin người đặt hàng</h3>
      <form @submit.prevent="handleSubmit">
        <div>
          <input
            type="text"
            id="name"
            v-model="orderInfo.name"
            placeholder="Tên người đặt"
            required
            class="input-field"
          />
        </div>
        <div>
          <input
            type="tel"
            id="phone"
            v-model="orderInfo.phone"
            placeholder="Số điện thoại"
            required
            class="input-field"
          />
        </div>
        <div>
          <input
            type="text"
            id="address"
            v-model="orderInfo.address"
            placeholder="Địa chỉ nhận hàng"
            required
            class="input-field"
          />
        </div>
        <div>
          <label>Phương thức thanh toán</label>
          <div class="payment-method-line"></div>
          <div class="payment-options">
            <label>
              <input type="radio" value="tiền mặt" v-model="orderInfo.paymentMethod" /> Tiền mặt
            </label>
            <label>
              <input type="radio" value="zaloPay" v-model="orderInfo.paymentMethod" /> ZaloPay
            </label>
            <label>
              <input type="radio" value="momo" v-model="orderInfo.paymentMethod" /> MoMo
            </label>
            <label>
              <input type="radio" value="thẻ ngân hàng" v-model="orderInfo.paymentMethod" /> Thẻ
              ngân hàng
            </label>
          </div>
        </div>
        <button type="submit" style="color: white; background-color: brown">Thanh toán</button>
      </form>
    </div>
  </div>
</template>

<script>
import cart from '../data/cart';
import items from '../data/items';
export default {
  data() {
    return {
      cart: cart,
      orderInfo: {
        name: '',
        phone: '',
        address: '',
        paymentMethod: '',
      },
    };
  },
  computed: {
    tongtien() {
      return this.cart.reduce((total, item) => total + item.quantity * item.price, 0);
    },
    tongsoluong() {
      return this.cart.reduce((total, item) => total + item.quantity, 0);
    },
  },
  methods: {
    deleteproduct(item) {
      this.cart = this.cart.filter((x) => x.id !== item.id);
    },
    increaseQuantity(item) {
      const prod = items.find((i) => i.id === item.id);
      if (prod) {
        if (item.quantity < prod.quality) {
          item.quantity++;
        }
      }
    },
    decreaseQuantity(item) {
      const prod = items.find((i) => i.id === item.id);
      if (item.quantity > 1) {
        item.quantity--;
        prod.quality++;
      } else {
        this.deleteproduct(item);
      }
    },
  },
};
</script>

<style>
.modal-content {
  display: flex;
  background: #d6ddb88c;
}
.cart-items {
  margin-top: 50px;
  flex: 1;
  margin-right: 20px;
}
.order-info {
  margin-top: 50px;
  flex: 1;
  border: 1px solid #ccc;
  padding: 10px;
}
.input-field {
  width: 100%;
  padding: 8px;
  margin: 5px 0;
  box-sizing: border-box;
}
.payment-method-line {
  height: 2px;
  background-color: green;
  margin: 5px 0;
}
.payment-options {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
}
</style>
