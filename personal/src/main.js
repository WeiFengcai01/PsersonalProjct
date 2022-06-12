import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import router from './router'
import store from './store'
import './plugins/element.js'

import VueAwesomeSwiper from 'vue-awesome-swiper'
import "swiper/dist/css/swiper.min.css"
import "swiper/dist/css/swiper.css"
import "swiper/dist/js/swiper"
require('es6-promise').polyfill();
require('es6-promise/auto');


Vue.use(VueAwesomeSwiper, /* { default global options } */)



Vue.config.productionTip = false
axios.defaults.baseURL="http://127.0.0.1:8181/";
Vue.prototype.$ajax=axios;


new Vue({
  router,
  store,

  render: h => h(App)
}).$mount('#app')

