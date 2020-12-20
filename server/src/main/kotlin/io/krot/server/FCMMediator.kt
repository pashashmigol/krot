package io.krot.server

import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import core.*

object FCMMediator : PlayersMediator(timeout = 5 * 60 * 1000) {
    override suspend fun send(challenge: Challenge, toPlayer: Player){
        return
    }

    override suspend fun notifyGameStarted(message: String, player: Player) {
        val registrationToken = player.fcmToken

        val toSend: Message = Message.builder()
            .putData("message", message)
            .setToken(registrationToken)
            .build()

        val response: String = FirebaseMessaging
            .getInstance()
            .send(toSend)
        println("Successfully sent message: $response")
    }

    override suspend fun notifyGameFinished(message: String, player: Player) {
        TODO("Not yet implemented")
    }
}