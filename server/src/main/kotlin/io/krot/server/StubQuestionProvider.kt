package io.krot.server

import core.Challenge

object StubQuestionProvider : QuestionProvider {
    override fun obtainNewChallenge(gameId: String, index: Int): Challenge {
        return Challenge(
                id  =  "$gameId-$index",
                gameId = gameId,
                question =  "40+2",
                correctAnswer =  "42")
    }
}