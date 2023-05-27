import Vue from 'vue';
import App from './App.vue';
import axios from "axios";//引入AXIOS
Vue.prototype.$axios = axios;//挂载AXIOS
import * as echarts from 'echarts';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import './map/js/world';
Vue.prototype.$echarts = echarts;
Vue.config.productionTip = false;
import jsonp from "jsonp";
Vue.use(ElementUI);

axios.defaults.baseURL="http://localhost:8081";
Vue.prototype.$http=axios;

new Vue({
  render: h => h(App),
}).$mount('#app')
