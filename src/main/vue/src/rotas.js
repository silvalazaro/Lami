import ListaUsuario from './desktop/cadastro/ListaUsuario.vue'
import Vue from 'vue'
import VueRouter from 'vue-router'
Vue.use(VueRouter)
export default new VueRouter({
  routes: [
    {
      path: '/foo',
      component: { template: '<div><h1>foo</h1></div>' }
    },
    {
      path: '/usuario',
      component: ListaUsuario
    }
  ]
})
