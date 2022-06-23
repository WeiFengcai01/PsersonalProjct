import Vue from 'vue'
import VueRouter from 'vue-router'


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: '首页',
    component: ()=>import("@/components/index"),

  }
  ,

  {
    path: '/message',
    name: '留言',
    component :()=>import('@/components/Message')
}
  ,
  {
    path: '',
    name: '相册',
    // component
  },
  {
    path: '/autome',
    name: '关于我',
    component :()=>import('@/components/autome')
  },
  {
    path: '/admin',
    meta:{
      requireAuth:true,
    },
    component:()=>import('@/components/Admin/Index')
  }
    ,{
  path:"/admin",
    name: '留言管理',
    hidden:true,
    children: [
        {
          path: '/message/eit',
          name:'留言管',
    },
    ]
  }
  ,
  {
    path: '/login',
    component:()=>import('@/components/Admin/login')
  }


]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
