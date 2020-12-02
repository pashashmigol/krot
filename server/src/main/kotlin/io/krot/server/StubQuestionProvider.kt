package io.krot.server

import core.Challenge
import http.routing.QuestionProvider

object StubQuestionProvider : QuestionProvider {
    override fun obtainNewChallenge(gameId: String): Challenge {
        return Challenge(
                id  =  "",
                gameId = gameId,
                question =  "40+2",
                correctAnswer =  "42")
    }
}