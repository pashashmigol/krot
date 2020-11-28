package core

import com.soywiz.klock.TimeSpan

data class Answer(
    val gameId: String,
    val playerId: String,
    val challengeId: String,
    val answer: String,
    val tookTime: TimeSpan
) {
    companion object{
        fun timeout(playerId: String) = Answer(
                gameId = "",
                playerId = playerId,
                challengeId = "",
                answer = "TIMEOUT",
                tookTime = TimeSpan.NIL
        )
        fun noAnswer(playerId: String) = Answer(
                gameId = "",
                playerId = "",
                challengeId = "",
                answer = "NO_ANSWER",
                tookTime = TimeSpan.NIL
        )

        fun leave(playerId: String) = Answer(
                gameId = "",
                playerId = playerId,
                challengeId = "",
                answer = "LEAVE_THE_GAME",
                tookTime = TimeSpan.NIL
        )
    }

    override fun toString(): String {
        return "Answer(gameId='$gameId', " +
                "playerId='$playerId', " +
                "challengeId='$challengeId', " +
                "answer='$answer', " +
                "tookTime=$tookTime)"
    }
}