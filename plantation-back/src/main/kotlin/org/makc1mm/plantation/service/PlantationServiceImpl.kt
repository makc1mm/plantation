package org.makc1mm.plantation.service

import kotlinx.coroutines.*
import org.makc1mm.plantation.model.Plantation
import org.slf4j.LoggerFactory
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

@Service
class PlantationServiceImpl : PlantationService {

    private val logger = LoggerFactory.getLogger(this::class.java)

    private val plantation = Plantation()
    private val maxValue = 10

    override fun getPlantationInfo(): Plantation {
        return plantation
    }

    override fun addWater() {
        plantation.water = 10
    }

    override fun pickUpPlants() {
        plantation.plants = 0
    }

    @EventListener(ApplicationReadyEvent::class)
    private fun startPlantation() {
        CoroutineScope(Dispatchers.Default).apply {
            launch {
                while (isActive) {
                    if (plantation.water > 0 && plantation.energy != maxValue) {
                        plantation.water--
                        plantation.energy++
                        logger.info("Added energy. Count ${plantation.energy}")
                        delay(1000)
                    }
                }
            }
            launch {
                while (isActive) {
                    if (plantation.energy > 0 && plantation.plants != maxValue) {
                        plantation.plantsGrowing = true
                        plantation.energy--
                        plantation.plants++
                        logger.info("Added plant. Count: ${plantation.plants}")
                        delay(2000)
                    } else {
                        plantation.plantsGrowing = false
                    }
                }
            }
        }
    }
}