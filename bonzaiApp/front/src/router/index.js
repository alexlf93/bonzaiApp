import { createRouter, createWebHistory } from 'vue-router'
import ProductsView from "../modules/products/views/ProductsView.vue";
import SideComponent from "../modules/global/components/SideComponent.vue";
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'Products',
      components:{
        aside: SideComponent,
        default: ProductsView
      }
    }
  ]
})

export default router
