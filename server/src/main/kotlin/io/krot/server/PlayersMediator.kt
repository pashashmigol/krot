package io.krot.server

import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.withTimeoutOrNull
import core.*

abstract class PlayersMediator(private val timeout: Long = 60_000) {
    private val coroutineScope = GlobalScope

    private val answers1 = CompletableDeferred<Answer>()
    private val answers2 = CompletableDeferred<Answer>()

    private var players: Pair<Player, Player>? = null

    suspend fun retrieveAnswers(players: Pair<Player, Player>,
                                challenge: Challenge): Res<Pair<Answer, Answer>> {

        this.players = players
        send(challenge = challenge, toPlayer = players.first)
        send(challenge = challenge, toPlayer = players.second)


        val answer2 = withTimeoutOrNull(timeout) {
            answers2.await()
        } ?: Answer.timeout(players.second.id)

        val answer1 = withTimeoutOrNull(timeout) {
            answers1.await()
        } ?: Answer.timeout(players.first.id)

        return Res.Success(Pair(answer1, answer2))
    }

    fun submitAnswer(answer: Answer): Res<String> {
        return when (answer.playerId) {
            players?.first?.id -> {
                answers1.complete(answer)
                Res.Success("success")
            }
            players?.second?.id -> {
                answers2.complete(answer)
                Res.Success("success")
            }
            else -> {
                Res.Error("No player with id ${answer.playerId} waiting for answers")
            }
        }
    }

    abstract suspend fun send(challenge: Challenge, toPlayer: Player)

    abstract suspend fun notifyGameStarted(message: String, player: Player)

    abstract suspend fun notifyGameFinished(result: String, player: Player)
}