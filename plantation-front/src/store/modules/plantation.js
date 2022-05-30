import axios from "axios";

export default {
    state: {
        plantation: {
            water: 0,
            energy: 0,
            plants: 0,
            plantsGrowing: false
        }
    },
    getters: {
        getPlantation(state) {
            return state.plantation
        }
    },
    mutations: {
        updatePlantation(state, plantation) {
            state.plantation = plantation
        }
    },
    actions: {
        addWater() {
            axios.post("http://localhost:8081/api/addWater").then(_ => {
                console.log("Water was added")
            })
        },
        pickUpPlants() {
            axios.post("http://localhost:8081/api/pickUpPlants").then(_ => {
                console.log("Plants was picked up")
            })
        },
        connectWebSocket(ctx) {
            this.socket = new WebSocket("ws://localhost:8081/ws")
            this.socket.onopen = () => {
                console.log("WebSocket was opened")
            }
            this.socket.onmessage = msg => {
                ctx.commit("updatePlantation", JSON.parse(msg.data))
            }
            setInterval(() => {
                this.socket.send(new Date())
            }, 300)
        }
    }
}
