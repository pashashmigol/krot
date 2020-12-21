package io.krot.server

import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import core.Challenge
import core.Player
import core.Settings.ANSWER_TIMEOUT

object FCMMediator : PlayersMediator(timeout = ANSWER_TIMEOUT) {

    override suspend fun sendChallenge(
        challenge: Challenge,
        players: Pair<Player, Player>
    ) {
        val data = mapOf(
            "type" to "challenge",
            "gameId" to challenge.gameId,
            "challengeId" to challenge.id,
            "question" to challenge.question,
        )
        players.toList().forEach {
            val response = sendMessage(
                data = data,
                token = it.fcmToken
            )
            println("Successfully sent message: $response")
        }
    }

    override suspend fun notifyGameStarted(
        message: String,
        gameId: String,
        players: Pair<Player, Player>
    ) {
        val data = mapOf(
            "type" to "started",
            "gameId" to gameId,
            "message" to message,
        )
        players.toList().forEach {
            val response = sendMessage(
                data = data,
                token = it.fcmToken
            )
            println("notifyGameStarted(); sent message: $response")
        }
    }

    override suspend fun notifyGameFinished(
        result: String,
        gameId: String,
        player: Player
    ) {
        val data = mapOf(
            "type" to "ended",
            "gameId" to gameId,
            "result" to result,
        )
        val response = sendMessage(
            data = data,
            token = player.fcmToken
        )
        println("notifyGameFinished(); sent message: $response")
    }

    private fun sendMessage(
        data: Map<String, String>,
        token: String
    ): String {
        val toSend: Message = Message.builder()
            .putAllData(data)
            .setToken(token)
            .build()

        return FirebaseMessaging
            .getInstance()
            .send(toSend)
    }
}