import Vuex from 'vuex';
import state from './state';
import getters from './getter';
import mutations from './mutation';
import actions from './action';
const store = new Vuex.Store({
  state,
  getters,
  mutations,
  actions,
});
export default store;
