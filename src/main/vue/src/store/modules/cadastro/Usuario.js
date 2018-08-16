const fields = [
    {
      name: 'id',
      type: 'int'
    },{
      name: 'email',
      type: 'string'
    }, {
      name: 'email',
      type: 'string'
    }, {
      name: 'ativo',
      type: 'boolean'
    }
]
const state = {
  all: []
}

const getters = {
  fields() {
    return fields
  }
}

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
  mutations
}
