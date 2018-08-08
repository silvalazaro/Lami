import '@babel/polyfill'
import './plugins/vuetify'
import Vue from 'vue'
import VueRouter from 'vue-router'
import App from './App.vue'
import { library, dom } from '@fortawesome/fontawesome-svg-core'
import { fas } from '@fortawesome/free-solid-svg-icons'
import router from './rotas'
import store from './store/index'

Vue.config.productionTip = false
library.add(fas)
dom.watch()

new Vue({
  render: h => h(App),
  router,
  store
}).$mount('#app')
