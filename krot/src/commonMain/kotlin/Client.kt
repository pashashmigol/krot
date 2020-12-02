import com.soywiz.klock.DateTime
import core.Player
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

class Client {
    private val client = HttpClient()
    private val root = "https://bored-passenger-290806.oa.r.appspot.com"
    private var status = Url("$root/status")
    private var enterGame = Url("$root/enter")

    suspend fun askServerStatus(): String = client.get {
        url(this@Client.status).toString()
    }

    suspend fun enterGame(): String {
        val place : Player

        return client.post() {
            url(this@Client.enterGame).toString()
        }
    }
}