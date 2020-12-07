import core.Player
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.json.Json

class Client {
    private val client = HttpClient()
    private val root = "https://bored-passenger-290806.oa.r.appspot.com"
    private var status = Url("$root/status")
    private var enterGame = Url("$root/enter")

    suspend fun askServerStatus(): String = client.get {
        url(this@Client.status).toString()
    }

    suspend fun enterGame(): String {
        val player = Player(
            id = "2",
            nickName = "pasha",
            lat = 0.0f, long = 0.0f, radius = 0.0f,
            fcmToken = "111"
        )

        return client.post {
            url(this@Client.enterGame).toString()
            contentType(ContentType.Application.Json)
            body = Json.encodeToString(PlayerSerializer, player)
        }
    }
}