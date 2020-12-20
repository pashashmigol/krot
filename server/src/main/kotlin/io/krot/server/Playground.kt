package io.krot.server

import core.Answer
import core.Player
import core.Res
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

object Playground {
    private val waitingPlayers = mutableMapOf<String, Player>()
    private val playersInGame = mutableMapOf<String, GameProcess>()
    private val activeGames = mutableMapOf<String, GameProcess>()

    private val coroutineScope = GlobalScope

    var mediator: PlayersMediator = FCMMediator

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

    fun leave(player: Player): Res<Boolean> {
        if (waitingPlayers.contains(player.id)) {
            waitingPlayers.remove(player.id)
            return Res.Success(true)
        }
        if (playersInGame.contains(player)) {
            waitingPlayers.remove(player)
            return Res.Success(true)
        }
        return Res.Error("No such player with id ${player.id} in playground")
    }

    private fun mayEnter(player: Player): Boolean =
        !waitingPlayers.containsKey(player.id) && !playersInGame.containsKey(player.id)

    private fun tryToStartGame() {
        val players = mutableListOf<Player>()
        players.addAll(waitingPlayers.values)
        if (players.size < 2) {
            return
        }
        val game = GameProcess(
            questionProvider = StubQuestionProvider,
            mediator = mediator,
            player1 = players[0],
            player2 = players[1]
        )
        activeGames[game.id] = game

        coroutineScope.launch {
            players.forEach {
                mediator.notifyGameStarted(
                    "Game between ${players[0]} and ${players[1]} started", it
                )
            }
            game.start()
        }
    }

    fun reset() {
        waitingPlayers.clear()
        playersInGame.clear()
        activeGames.clear()
    }
}