<template>
  <b-container class="container">
    <b-row>
      <b-col>
        <ul class="params">
          <li class="water" @click=addWater>
            <b-badge class="badge bg-primary">{{ getPlantation.water }}</b-badge>
          </li>
          <li class="txt">+</li>
          <li class="energy">
            <b-badge class="badge bg-warning text-dark">{{ getPlantation.energy }}</b-badge>
          </li>
          <li class="txt">=</li>
          <li class="plants" @click=pickUpPlants>
            <b-badge class="badge bg-success">{{ getPlantation.plants }}</b-badge>
          </li>
        </ul>
        <div>
          <h3>Water: {{ getPlantation.water }}</h3>
          <b-progress :value="getPlantation.water" :max="10" animated variant="primary"></b-progress>
          <h3>Energy: {{ getPlantation.energy }}</h3>
          <b-progress :value="getPlantation.energy" :max="10" animated variant="warning"></b-progress>
          <h3>Plants: {{ getPlantation.plants }}</h3>
          <b-progress :value="getPlantation.plants" :max="10" animated variant="success"></b-progress>
        </div>
      </b-col>
    </b-row>
    <div>
      <img v-if="getPlantation.plantsGrowing" src="/grow.gif" class="rounded" alt="growing">
      <img v-else src="/static-grow.png" class="rounded" alt="not growing">
    </div>
<!--    {{ getPlantation }}-->
  </b-container>
</template>

<script>
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import { mapGetters, mapActions } from 'vuex'

export default {
  computed: mapGetters(["getPlantation"]),
  methods: mapActions(["addWater", "pickUpPlants", "connectWebSocket"]),

  mounted() {
    this.connectWebSocket()
  }
}
</script>

<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

.container {
  text-align: center;
  justify-content: center;
}

.params {
  list-style: none;
  display: inline-flex;
}

.params li {
  width: 80px;
  height: 80px;
  border-radius: 50%;
  border: black 3px solid;
}

.params li.txt {
  border: none;
  line-height: 80px;
}

.params li.water {
  background: #fff url(/public/water.png) no-repeat center center/cover;
  cursor: pointer;
}

.params li.energy {
  background: #fff url(/public/energy.png) no-repeat center center/cover;
}

.params li.plants {
  background: #fff url(/public/plants.png) no-repeat center center/cover;
  cursor: pointer;
}

img {
  padding-top: 20px;
}
</style>
