package io.krot.server

import core.Challenge


interface QuestionProvider {
    fun obtainNewChallenge(gameId: String, index: Int): Challenge
}