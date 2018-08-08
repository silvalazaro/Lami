import Vue from 'vue'
import Vuex from 'vuex'
import cadastro from './modules/cadastro'
Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    cadastro
  }
})
