package org.makc1mm.plantation.webSocket.handler

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.makc1mm.plantation.service.PlantationService
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler

class WebSocketHandler(private val service: PlantationService) : TextWebSocketHandler() {

    private val objectMapper = jacksonObjectMapper()

    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        super.handleTextMessage(session, message)
        val msg = TextMessage(
            objectMapper.writeValueAsString(service.getPlantationInfo())
        )
        session.sendMessage(msg)
    }

}