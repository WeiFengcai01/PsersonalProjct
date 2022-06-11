import Vue from 'vue'
import VueRouter from 'vue-router'


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: '首页',
    component: ()=>import("@/components/index")
  },
  {
    path: '/meaaage',
    name: '给我留言',
    component: ()=>import("@/components/index")
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
