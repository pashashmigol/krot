package http.routing

import core.Challenge


interface QuestionProvider {
    fun obtainNewChallenge(gameId: String): Challenge
}