package org.makc1mm.plantation.controller

import org.makc1mm.plantation.model.Plantation
import org.makc1mm.plantation.service.PlantationService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = ["*"])
class PlantationController(private val service: PlantationService) {

    @GetMapping("/getInfo")
    fun getPlantationInfo(): Plantation {
        return service.getPlantationInfo()
    }

    @PostMapping("/addWater")
    fun addWater() {
        service.addWater()
    }

    @PostMapping("/pickUpPlants")
    fun pickUpPlants() {
        service.pickUpPlants()
    }
}