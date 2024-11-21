import { createWebHistory, createRouter } from "vue-router";
import Home from '@/components/ComHome.vue'
import ThucDon from '@/components/ComThucDon.vue'
import GioiThieu from '@/components/ComGioiTh.vue'
import LienHe from '@/components/ComLienHe.vue'
import TinTuc from '@/components/ComTinTuc.vue'
import ProductDetail from "@/components/ComProductDetail.vue";
import Cart from '@/components/ComCart.vue';
// tạo mảng chứa những đường link
const routes = [
    // đối tượng trang chủ
    {
        path: "/",
        name: "Home",
        component: Home
    },
    // đường link ko phải là trang chủ path:"/ten"
    {
    
        path: "/thucdon",
        name: "ThucDon",
        component: ThucDon
    },
    {
        path: "/gioithieu",
        name: "GioiThieu",
        component: GioiThieu
    },
    {
        path: "/lienhe",
        name: "LienHe",
        component: LienHe
    },
    {
        path: "/tintuc",
        name: "TinTuc",
        component: TinTuc
    },
    // vừa điều hướng vừa truyền dữ liệu đi qua
    {
        path: "/Product/:id",
        name: "ProductDetail",
        component: ProductDetail
    },
    {
        path: "/Cart",
        name: "Cart",
        component: Cart
    },
]
// tạo đối tượng router
const router = createRouter({
    history: createWebHistory(),
    routes
})
export default router