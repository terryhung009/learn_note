import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Account from '@/components/Account.vue'
import Contact from '@/components/Contact.vue'
import Friends from '@/components/Friends.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/friends/:id/:age/:weight',
    name: 'Friends',
    props:true,
    component: Friends
  },
  {
    path: '/contact',
    name: 'Contact',
    component: Contact
  },
  {
    path: '/account',
    name: 'Account',
    component: Account
  },
]

const router = new VueRouter({
  routes
})

export default router
