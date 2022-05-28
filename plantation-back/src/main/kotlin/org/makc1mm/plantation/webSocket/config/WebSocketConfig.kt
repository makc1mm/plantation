package org.makc1mm.plantation.webSocket.config

import org.makc1mm.plantation.service.PlantationService
import org.makc1mm.plantation.webSocket.handler.WebSocketHandler
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.config.annotation.*

@Configuration
@EnableWebSocket
class WebSocketConfig(private val service: PlantationService) : WebSocketConfigurer {

    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry.addHandler(WebSocketHandler(service), "/ws").setAllowedOrigins("*")
    }
}