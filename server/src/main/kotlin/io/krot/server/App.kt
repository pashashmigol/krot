package io.krot.server

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import core.Answer
import core.Player
import core.Settings.CREDENTIALS_FILE_NAME
import core.Settings.DATABASE_URL
import io.ktor.features.*
import io.ktor.gson.*
import org.slf4j.event.Level
import java.io.FileInputStream

private val serviceAccount = FileInputStream(CREDENTIALS_FILE_NAME)
val credentials: GoogleCredentials = GoogleCredentials.fromStream(serviceAccount)

fun Application.main() {
    install(CallLogging) {
        level = Level.TRACE
    }
    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
        }
    }
    routing {
        get("/status") {
            call.respond("Server is running!")
        }
        post("/enter") {
            val player = call.receive<Player>()
            val result = Playground.enter(player)
            call.respond(
                status = HttpStatusCode.OK,
                message = result
            )
        }
        post("/submitAnswer") {
            val answer = call.receive<Answer>()
            val result = Playground.submitAnswer(answer)

            call.respond(
                status = HttpStatusCode.OK,
                message = result
            )
        }

        post("/leave") {
            val data = call.receive<Map<String, String>>()
            val playerId = data["playerId"]

            if(playerId.isNullOrBlank()){
                call.respond(
                    status = HttpStatusCode.BadRequest,
                    message = "result"
                )
                return@post
            }
            val result = Playground.leave(playerId)

            call.respond(
                status = HttpStatusCode.OK,
                message = result
            )
        }
        initFCM()
    }
}

private fun initFCM() {
    val options: FirebaseOptions = FirebaseOptions.builder()
        .setCredentials(credentials)
        .setDatabaseUrl(DATABASE_URL)
        .build()
    FirebaseApp.initializeApp(options)
}