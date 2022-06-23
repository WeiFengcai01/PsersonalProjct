import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import router from './router'
import store from './store'
import './plugins/element.js'
import VueAwesomeSwiper from 'vue-awesome-swiper'
import 'swiper/dist/css/swiper.css'



require('es6-promise').polyfill();
require('es6-promise/auto');


Vue.use(VueAwesomeSwiper);



Vue.config.productionTip = false
axios.defaults.baseURL="http://localhost:8181/";
Vue.prototype.$ajax=axios;

// 路由判断登录 根据路由配置文件的参数
router.beforeEach((to, from, next) => {
  if (to.matched.some(record => record.meta.requireAuth)){ // 判断该路由是否需要登录权限
    console.log('需要登录');
    if (localStorage.token) { // 判断当前的token是否存在 ； 登录存入的token
      next();
    }
    else {
      next({
        path: '/login',
        query: {redirect: to.fullPath} // 将跳转的路由path作为参数，登录成功后跳转到该路由
      })
    }
  }
  else {
    next();
  }
});

new Vue({
  router,
  store,

  render: h => h(App)
}).$mount('#app')

