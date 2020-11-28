package core

data class GameStartedInfo(
        val gameId: String,
        val opponent: Player) {

    override fun toString(): String {
        return "GameResult(gameId = $gameId, opponent = $opponent)"
    }
}

const val PLAYER_1_WON = "player_1_won"
const val PLAYER_2_WON = "player_2_won"
const val DRAW = "draw"
const val ACTIVE = "active"