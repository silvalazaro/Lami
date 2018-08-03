const fields = {
  id: {
    tipo: 'int'
  },
  email: {
    tipo: 'string'
  },
  cpf: {
    tipo: 'string'
  },
  ativo: {
    tipo: 'boolean'
  }
}
const state = {
  all: []
}

const getters = {}

const actions = {
  getAll({ commit }) {
    // TODO server
  }
}

const mutations = {
  setAll(state, usuarios) {
    state.all = usuarios
  }
}

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations,
  fields
}
