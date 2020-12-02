package http.routing

import model.*

object FCMMediator : PlayersMediator() {
    override suspend fun send(challenge: Challenge, toPlayer: Player){
        return
    }

    override suspend fun notifyGameStarted(message: String) {
        TODO("Not yet implemented")
    }

    override suspend fun notifyGameFinished(message: String) {
        TODO("Not yet implemented")
    }
}