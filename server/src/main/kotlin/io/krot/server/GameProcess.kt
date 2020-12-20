package io.krot.server

import com.soywiz.klock.DateFormat
import com.soywiz.klock.DateTime
import kotlinx.coroutines.GlobalScope
import core.*

const val WINS_TO_FINISH = 3
const val DRAWS_TO_FINISH = 3

data class GameProcess(val questionProvider: QuestionProvider,
                       private val mediator: PlayersMediator,
                       val player1: Player,
                       val player2: Player
) {
    val id = DateTime.now().toString(DateFormat.FORMAT1)
    private val scope = GlobalScope

    suspend fun start() {
        val challenge = questionProvider.obtainNewChallenge(id)

        var player1Wins = 0
        var player2Wins = 0
        var draws = 0

        while (player1Wins < WINS_TO_FINISH
                && player2Wins < WINS_TO_FINISH
                && draws < DRAWS_TO_FINISH
        ) {

            val answers: Pair<Answer, Answer> = mediator.retrieveAnswers(
                    players = Pair(player1, player2),
                    challenge = challenge
            ).dealWithError {
                return
            }

            if(hasLeft(answers.first) && hasLeft(answers.second)){
                mediator.notifyGameFinished(DRAW, player1)
                mediator.notifyGameFinished(DRAW, player2)
                return
            }
            if(hasLeft(answers.first)){
                mediator.notifyGameFinished(PLAYER_2_WON, player1)
                mediator.notifyGameFinished(PLAYER_2_WON, player2)
                return
            }
            if(hasLeft(answers.second)){
                mediator.notifyGameFinished(PLAYER_1_WON, player1)
                mediator.notifyGameFinished(PLAYER_1_WON, player2)
                return
            }
            val winnerId = defineWinner(answers.first, answers.second, challenge)

            if (winnerId == player1.id) player1Wins++
            if (winnerId == player2.id) player2Wins++
            if (winnerId == "") draws++
        }

        if (player1Wins == WINS_TO_FINISH) {
            mediator.notifyGameFinished(PLAYER_1_WON, player1)
            mediator.notifyGameFinished(PLAYER_1_WON, player2)
        }
        if (player2Wins == WINS_TO_FINISH) {
            mediator.notifyGameFinished(PLAYER_2_WON, player1)
            mediator.notifyGameFinished(PLAYER_2_WON, player2)
        }
        if (draws == DRAWS_TO_FINISH) {
            mediator.notifyGameFinished(DRAW, player1)
            mediator.notifyGameFinished(DRAW, player2)
        }
    }

    private fun hasLeft(answer: Answer): Boolean {
        return answer.answer == "LEAVE_THE_GAME"
    }

    fun submitAnswer(answer: Answer): Res<String> {
        print("submitAnswer(): answer = $answer")
        return mediator.submitAnswer(answer)
    }

    private fun defineWinner(player1Answer: Answer,
                             player2Answer: Answer,
                             challenge: Challenge): String {

        print("defineWinner(): player1Answer = $player1Answer, " +
                "player2Answer = $player2Answer, challenge = $challenge")

        if (!isAnswerCorrect(player1Answer, challenge)
                && !isAnswerCorrect(player2Answer, challenge)) {
            return ""
        }
        if (isAnswerCorrect(player1Answer, challenge)
                && !isAnswerCorrect(player2Answer, challenge)) {
            return player1Answer.playerId
        }
        if (isAnswerCorrect(player2Answer, challenge)
                && !isAnswerCorrect(player1Answer, challenge)) {
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

    private fun isAnswerCorrect(answer: Answer, challenge: Challenge) = challenge.correctAnswer == answer.answer
}