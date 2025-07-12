import { createRouter, createWebHistory } from 'vue-router'
import CategoryView from '@/views/CategoryView.vue'
import ProductView from '@/views/ProductView.vue'
import UserView from '@/views/UserView.vue'

const routes = [
    { path: '/', redirect: '/categories' },
    { path: '/categories', component: CategoryView },
    { path: '/products', component: ProductView },
    { path: '/users', component: UserView }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router
