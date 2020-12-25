import core.Answer
import core.Player
import core.Res
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.http.HttpStatusCode.Companion.OK
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

@ExperimentalSerializationApi
class Client(private val root: String, private val tellTime: () -> Long) {
    companion object {
        const val TAG = "Client"
    }

    interface Listener {
        fun onAnyEvent(event: String, data: Map<String, String?>?)
        fun onGameStarted(message: String)
        fun onChallenge(question: String)
        fun onGameEnded(message: String)
        fun onError(message: String)
    }

    private val client = HttpClient {
        expectSuccess = false
    }

    private var status = "$root/status"
    private var enterGame = "$root/enter"
    private var leaveGame = "$root/leave"
    private var submitAnswer = "$root/submitAnswer"

    private val listeners = mutableListOf<Listener>()
    fun addListener(listener: Listener) = listeners.add(listener)
    fun removeListener(listener: Listener) = listeners.remove(listener)

    private var currentPlayerId: String? = null
    private var currentGameId: String? = null
    private var currentChallengeId: String? = null
    private var challengeStartedAt: Long = 0

    suspend fun askServerStatus(): String = client.get {
        url(this@Client.status).toString()
    }

    var token: String = ""

    suspend fun enterGame(player: Player): Res<String> = try {
        this.currentPlayerId = player.id

        val res = client.post<HttpResponse> {
            url(enterGame)
            contentType(ContentType.Application.Json)
            body = Json.encodeToString(PlayerSerializer, player)
        }
        notifyAnyEvent("enterGame(); res = ${res.status}")
        when (res.status) {
            OK -> Res.Success(data = res.readText())
            else -> Res.Error(message = res.toString())
        }
    } catch (e: Exception) {
        Res.Error(message = "$TAG.enterGame(): $e")
    }

    private suspend fun leaveGame(): Res<String> {
        val playerId = currentPlayerId ?: return Res.Error("no current player!")

        return try {
            val res = client.post<HttpResponse> {
                url(leaveGame)
                contentType(ContentType.Application.Json)
                body = "{ playerId : \"$playerId\"}"
            }
            notifyAnyEvent("enterGame(); res = ${res.status}")
            when (res.status) {
                OK -> Res.Success(data = res.readText())
                else -> Res.Error(message = res.toString())
            }
        } catch (e: Exception) {
            notifyError(e.toString())
            Res.Error(message = "$TAG.submitAnswer(); $e")
        }
    }

    suspend fun submitAnswer(answer: String): Res<String> {
        val playerId = currentPlayerId ?: return Res.Error("no current player!")
        val gameId = currentGameId ?: return Res.Error("no current game!")
        val challengeId = currentChallengeId ?: return Res.Error("no current challenge!")

        val answerToSend = Answer(
            gameId = gameId,
            playerId = playerId,
            challengeId = challengeId,
            answer = answer,
            tookTime = ((tellTime() - challengeStartedAt) / 1000).toInt()
        )

        return try {
            val res = client.post<HttpResponse> {
                url(submitAnswer)
                contentType(ContentType.Application.Json)
                body = Json.encodeToString(AnswerSerializer, answerToSend)
            }
            notifyAnyEvent("submitAnswer(); res = ${res.status}")
            when (res.status) {
                OK -> Res.Success(data = res.readText())
                else -> Res.Error(message = res.toString())
            }
        } catch (e: Exception) {
            notifyError(e.toString())
            Res.Error(message = "$TAG.submitAnswer(); $e")
        }
    }

    fun handlePush(data: Map<String, String?>) {
        notifyAnyEvent("handlePush();", data)
        when (data["type"]) {
            "started" -> gameStarted(data)
            "challenge" -> challengeReceived(data)
            "ended" -> gameEnded(data)
        }
    }

    private fun gameStarted(data: Map<String, String?>) {
        val gameId = data["gameId"]!!
        val message = data["message"]!!

        currentGameId = gameId
        listeners.forEach { it.onGameStarted(message) }
    }

    private fun challengeReceived(data: Map<String, String?>) {
        val gameId = data["gameId"]
        val challengeId = data["challengeId"]!!
        val question = data["question"]!!

        if (gameId != currentGameId) {
            val error = "Got wrong game Id from server"
            listeners.forEach { it.onError(error) }
            interruptCurrentGame(error)
            return
        }
        currentChallengeId = challengeId
        challengeStartedAt = tellTime()
        listeners.forEach { it.onChallenge(question) }
    }

    private fun gameEnded(data: Map<String, String?>) {
        val gameId = data["gameId"]
        val result = data["result"]!!

        if (gameId != currentGameId) {
            val error = "Got wrong game Id from server"
            listeners.forEach { it.onError(error) }
            interruptCurrentGame(error)
            return
        }
        listeners.forEach { it.onGameEnded(result) }
    }

    private fun interruptCurrentGame(message: String) {
        notifyError("interruptCurrentGame(); $message")
        GlobalScope.launch {
            leaveGame()
        }
    }

    private fun notifyAnyEvent(event: String, data: Map<String, String?>? = null) {
        listeners.forEach { it.onAnyEvent(event, data) }
    }

    private fun notifyError(message: String) {
        listeners.forEach { it.onError(message) }
    }
}