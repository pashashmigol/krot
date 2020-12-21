package io.krot.server

import core.Answer
import core.Challenge
import core.Player
import core.Res
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.withTimeoutOrNull

abstract class PlayersMediator(private val timeout: Long = 60_000) {

    lateinit var answers: Pair<CompletableDeferred<Answer>, CompletableDeferred<Answer>>
    private var players: Pair<Player, Player>? = null

    suspend fun retrieveAnswers(
        players: Pair<Player, Player>,
        challenge: Challenge
    ): Res<Pair<Answer, Answer>> {

        answers = Pair(CompletableDeferred(), CompletableDeferred())

        this.players = players
        sendChallenge(
            challenge = challenge,
            players = Pair(players.first, players.second)
        )

        val answer2 = withTimeoutOrNull(timeout) {
            answers.second.await()
        } ?: Answer.timeout(players.second.id)

        val answer1 = withTimeoutOrNull(timeout) {
            answers.first.await()
        } ?: Answer.timeout(players.first.id)

        return Res.Success(Pair(answer1, answer2))
    }

    fun submitAnswer(answer: Answer): Res<String> {
        return when (answer.playerId) {
            players?.first?.id -> {
                answers.first.complete(answer)
                Res.Success("success")
            }
            players?.second?.id -> {
                answers.second.complete(answer)
                Res.Success("success")
            }
            else -> {
                Res.Error("No player with id ${answer.playerId} waiting for answers")
            }
        }
    }

    abstract suspend fun sendChallenge(challenge: Challenge, players: Pair<Player, Player>)

    abstract suspend fun notifyGameStarted(message: String, gameId: String, players: Pair<Player, Player>)

    abstract suspend fun notifyGameFinished(result: String, gameId: String, player: Player)
}