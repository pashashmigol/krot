package io.krot.server

import core.Answer
import core.Player
import core.Res
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

object Playground {
    private val waitingPlayers = mutableMapOf<String, Player>()
    private val playersInGame = mutableMapOf<String, Player>()
    private val activeGames = mutableMapOf<String, Game>()

    private val coroutineScope = GlobalScope
    private var mediator: PlayersMediator = FCMMediator
    private val questionProvider = GoogleSheetsQuestionsProvider()

    fun enter(player: Player): Res<String> {
        println("enter(); player = $player")

        if (mayEnter(player)) {
            waitingPlayers[player.id] = player
        } else {
            return Res.Error("player with id ${player.id} already registered")
        }
        tryToStartGame()
        return Res.Success("You are in")
    }

    fun submitAnswer(answer: Answer): Res<String> {
        val game = activeGames[answer.gameId]
            ?: return Res.Error("no game with id $answer.gameId")

        return game.submitAnswer(answer)
    }

    fun leave(playerId: String): Res<Boolean> {
        if (waitingPlayers.contains(playerId)) {
            waitingPlayers.remove(key = playerId)
            return Res.Success(true)
        }
        if (playersInGame.contains(key = playerId)) {
            waitingPlayers.remove(key = playerId)
            return Res.Success(true)
        }
        return Res.Error("No such player with id $playerId in playground")
    }

    private fun mayEnter(player: Player): Boolean =
        !waitingPlayers.containsKey(player.id) && !playersInGame.containsKey(player.id)

    private fun tryToStartGame() {
        val players = mutableListOf<Player>()
        players.addAll(waitingPlayers.values)
        if (players.size < 2) {
            return
        }
        val game = Game(
            questionProvider = questionProvider,
            mediator = mediator,
            player1 = players[0],
            player2 = players[1]
        )

        waitingPlayers.remove(key = players[0].id)
        waitingPlayers.remove(key = players[1].id)

        playersInGame[players[0].id] = players[0]
        playersInGame[players[1].id] = players[1]

        activeGames[game.gameId] = game

        coroutineScope.launch {
            mediator.notifyGameStarted(
                gameId = game.gameId,
                message = "Game between ${game.player1} and ${game.player2} started",
                players = Pair(game.player1, game.player2)
            )
            game.run()

            playersInGame.remove(key = players[0].id)
            playersInGame.remove(key = players[1].id)
        }
    }

    fun reset() {
        waitingPlayers.clear()
        playersInGame.clear()
        activeGames.clear()
    }
}