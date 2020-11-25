import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

class Client {
    private val client = HttpClient()
    var address = Url("https://tools.ietf.org/rfc/rfc1866.txt")

    suspend fun askServerStatus(): String {
//        val dateTime = DateTime.now()
//        return "now is $dateTime"

        return client.get {
            url(this@Client.address.toString())
        }
    }
}

