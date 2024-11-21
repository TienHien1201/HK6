import { createWebHistory, createRouter } from 'vue-router';
import Home from '@/components/ComHome.vue';
import Coffee from '@/components/ComCoffee.vue';
import Tea from '@/components/ComTea.vue';
import LienHe from '@/components/ComLienHe.vue';
import GioiThieu from '@/components/ComGioiThieu.vue';
import About from '@/components/ComAbout.vue';
import TinTuc from '@/components/ComTinTuc.vue';
import ProductDetail from '@/components/ComProductDetail.vue';
import Cart from '@/components/Cart-comp.vue';
import SignIn from '@/components/ComSignIn.vue';
import SignUp from '@/components/ComSignUp.vue';
import ComMaps from '@/components/ComMaps.vue';
import OrderDetail from '@/components/ComOrderDetail.vue';
// import CRUDProduct from '../components/ComCRUDProduct.vue';

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
  },
  {
    path: '/orderDetails',
    name: 'ComOrderDetail',
    component: OrderDetail,
  },
  // {
  //   path: '/CrudProduct',
  //   name: 'ComCRUDProduct',
  //   component: CRUDProduct,
  // },
  {
    path: '/maps',
    name: 'ComMaps',
    component: ComMaps,
  },
  {
    path: '/coffee',
    name: 'Coffee',
    component: Coffee,
  },
  {
    path: '/signin',
    name: 'SignIn',
    component: SignIn,
  },
  {
    path: '/signup',
    name: 'SignUp',
    component: SignUp,
  },
  {
    path: '/tea',
    name: 'Tea',
    component: Tea,
  },
  {
    path: '/gioithieu',
    name: 'GioiThieu',
    component: GioiThieu,
  },
  {
    path: '/lienhe',
    name: 'LienHe',
    component: LienHe,
  },
  {
    path: '/about',
    name: 'About',
    component: About,
  },
  {
    path: '/tintuc',
    name: 'TinTuc',
    component: TinTuc,
  },
  {
    path: '/product/:id',
    name: 'ProductDetail',
    component: ProductDetail,
    props: true,
  },
  {
    path: '/cart',
    name: 'Cart',
    component: Cart,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
