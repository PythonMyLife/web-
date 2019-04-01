import Vue from 'vue';
import Router from 'vue-router';
import Home from '../components/Home.vue'
import Login from '../components/login.vue'
import Regist from '../components/regist.vue'
import Subpage from '../components/subpage.vue'
import Cart from '../components/cart.vue'
import Manage from '../components/manage.vue'
import Order from '../components/order.vue'


Vue.use(Router);

export default new Router({
  mode: 'history',
  routes: [{
    path: '*',
    redirect: '/home'
  }, {
    path: '/home',
    name: 'Home',
    component: Home
  }, {
    path: '/login',
    name: 'login',
    component: Login
  }, {
    path: '/regist',
    name: 'regist',
    component: Regist
  }, {
    path: '/subpage',
    name: 'subpage',
    component: Subpage
  }, {
    path: '/cart',
    name: 'cart',
    component: Cart
  }, {
    path: '/manage',
    name: 'manage',
    component: Manage
  }, {
    path: '/order',
    name: 'order',
    component: Order
  }]
});