import core.Answer
import core.Player
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

@ExperimentalSerializationApi
class Client {
    private val client = HttpClient()
//    private val root = "https://bored-passenger-290806.oa.r.appspot.com"
    private val root = "http://10.0.2.2:8080"
    private var status = Url("$root/status")
    private var enterGame = Url("$root/enter")
    private var leaveGame = Url("$root/leave")
    private var submitAnswer = Url("$root/submitAnswer")

    suspend fun askServerStatus(): String = client.get {
        url(this@Client.status).toString()
    }

    var token: String = ""

    suspend fun enterGame(player: Player): String {

        return client.post {
            url(this@Client.enterGame).toString()
            contentType(ContentType.Application.Json)
            body = Json.encodeToString(PlayerSerializer, player)
        }
    }

    suspend fun leaveGame(): String {
        val player = Player(
            id = "2",
            nickName = "pasha",
            lat = 0.0f, long = 0.0f, radius = 0.0f,
            fcmToken = token
        )

        return client.post {
            url(this@Client.leaveGame).toString()
            contentType(ContentType.Application.Json)
            body = Json.encodeToString(PlayerSerializer, player)
        }
    }

    suspend fun submitAnswer(): String {
        val answer = Answer(
            gameId = "",
            playerId = "",
            challengeId = "",
            answer = "",
            tookTime = -1
        )

        return client.post {
            url(this@Client.submitAnswer).toString()
            contentType(ContentType.Application.Json)
            body = Json.encodeToString(AnswerSerializer, answer)
        }
    }

    fun handlePush(data: Map<String, String>){

    }
}