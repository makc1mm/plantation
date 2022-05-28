import Vue from 'vue'
import Vuex from 'vuex'
import plantation from "@/store/modules/plantation";

Vue.use(Vuex)

export default new Vuex.Store({
  modules: { plantation }
})
