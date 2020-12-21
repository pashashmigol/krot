package io.krot.server

import com.soywiz.klock.DateFormat
import com.soywiz.klock.DateTime
import core.*
import core.Settings.DRAWS_TO_FINISH
import core.Settings.WINS_TO_FINISH


data class Game(
    val questionProvider: QuestionProvider,
    private val mediator: PlayersMediator,
    val player1: Player,
    val player2: Player
) {
    enum class Result { PLAYER_1_WON, PLAYER_2_WON, DRAW }

    val gameId = DateTime.now().toString(DateFormat.FORMAT1)

    suspend fun run() {
        var player1Wins = 0
        var player2Wins = 0
        var draws = 0
        var challengeIndex = 0

        while (player1Wins < WINS_TO_FINISH
            && player2Wins < WINS_TO_FINISH
            && draws < DRAWS_TO_FINISH
        ) {
            val challenge = questionProvider.obtainNewChallenge(gameId, challengeIndex)
            challengeIndex++

            val answers: Pair<Answer, Answer> = mediator.retrieveAnswers(
                players = Pair(player1, player2),
                challenge = challenge
            ).dealWithError {
                return
            }
            if (hasLeft(answers.first) && hasLeft(answers.second)) {
                notifyResult(Result.DRAW)
                return
            }
            if (hasLeft(answers.first)) {
                notifyResult(Result.PLAYER_2_WON)
                return
            }
            if (hasLeft(answers.second)) {
                notifyResult(Result.PLAYER_1_WON)
                return
            }
            val winnerId = defineWinner(challenge, answers)

            if (winnerId == player1.id) player1Wins++
            if (winnerId == player2.id) player2Wins++
            if (winnerId == "") draws++
        }

        if (player1Wins == WINS_TO_FINISH) {
            notifyResult(Result.PLAYER_1_WON)
        }
        if (player2Wins == WINS_TO_FINISH) {
            notifyResult(Result.PLAYER_2_WON)
        }
        if (draws == DRAWS_TO_FINISH) {
            notifyResult(Result.DRAW)
        }
    }

    private fun hasLeft(answer: Answer): Boolean {
        return answer.answer == "LEAVE_THE_GAME"
    }

    fun submitAnswer(answer: Answer): Res<String> {
        print("submitAnswer(): answer = $answer")
        return mediator.submitAnswer(answer)
    }

    private suspend fun notifyResult(result: Result) {
        when (result) {
            Result.PLAYER_1_WON -> {
                notifyPlayer(player1, "You won!")
                notifyPlayer(player2, "You lost!")
            }
            Result.PLAYER_2_WON -> {
                notifyPlayer(player1, "You lost!")
                notifyPlayer(player2, "You won!")
            }
            Result.DRAW -> {
                val message = "It was a draw"
                notifyPlayer(player1, message)
                notifyPlayer(player2, message)
            }
        }
    }

    private suspend fun notifyPlayer(player: Player, message: String) {
        mediator.notifyGameFinished(
            result = message,
            gameId = gameId,
            player = player
        )
    }

    private fun defineWinner(
        challenge: Challenge,
        answers: Pair<Answer, Answer>
    ): String {

        val player1Answer = answers.first
        val player2Answer = answers.second

        print(
            "defineWinner(): player1Answer = $player1Answer, " +
                    "player2Answer = $player2Answer, challenge = $challenge"
        )

        if (!isAnswerCorrect(player1Answer, challenge)
            && !isAnswerCorrect(player2Answer, challenge)
        ) {
            return ""
        }
        if (isAnswerCorrect(player1Answer, challenge)
            && !isAnswerCorrect(player2Answer, challenge)
        ) {
            return player1Answer.playerId
        }
        if (isAnswerCorrect(player2Answer, challenge)
            && !isAnswerCorrect(player1Answer, challenge)
        ) {
            return player2Answer.playerId
        }
        return defineFastest(player1Answer, player2Answer)
    }

    private fun defineFastest(answer1: Answer, answer2: Answer): String {
        val tookTime1: Int = answer1.tookTime
        val tookTime2: Int = answer2.tookTime

        return when {
            tookTime1 > tookTime2 -> answer2.playerId
            tookTime1 < tookTime2 -> answer1.playerId
            else -> ""
        }
    }

    private fun isAnswerCorrect(answer: Answer, challenge: Challenge) =
        challenge.correctAnswer == answer.answer
}