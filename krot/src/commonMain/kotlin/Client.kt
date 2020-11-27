import com.soywiz.klock.DateTime
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

class Client {
    private val client = HttpClient()
    var address = Url("https://bored-passenger-290806.oa.r.appspot.com/status")

    suspend fun askServerStatus(): String {
        val dateTime = DateTime.now()

        return client.get<String> {
            url(this@Client.address.toString())
        } + dateTime
    }
}