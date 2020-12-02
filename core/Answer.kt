package core


data class Answer(
    val gameId: String,
    val playerId: String,
    val challengeId: String,
    val answer: String,
    val tookTime: Int
) {
    companion object {
        fun timeout(playerId: String) = Answer(
            gameId = "",
            playerId = playerId,
            challengeId = "",
            answer = "TIMEOUT",
            tookTime = -1
        )

        fun noAnswer(playerId: String) = Answer(
            gameId = "",
            playerId = "",
            challengeId = "",
            answer = "NO_ANSWER",
            tookTime = -1
        )

        fun leave(playerId: String) = Answer(
            gameId = "",
            playerId = playerId,
            challengeId = "",
            answer = "LEAVE_THE_GAME",
            tookTime = -1
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