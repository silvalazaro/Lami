import Vue from 'vue'
import Vuex from 'vuex'
import usuario from './modelo/cadastro/Usuario'
Vue.use(Vuex)

export default new Vuex.Store({
  modelo: {
    usuario
  }
})
