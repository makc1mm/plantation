package org.makc1mm.plantation.service

import org.makc1mm.plantation.model.Plantation

interface PlantationService {
    fun getPlantationInfo(): Plantation
    fun addWater()
    fun pickUpPlants()
}