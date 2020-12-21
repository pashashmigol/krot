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
import io.ktor.features.*
import io.ktor.gson.*
import org.slf4j.event.Level
import java.io.File
import java.io.FileInputStream


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
        post("/submitAnswer"){
            val answer = call.receive<Answer>()
            val result =  Playground.submitAnswer(answer)

            call.respond(
                status = HttpStatusCode.OK,
                message = result
            )
        }

        post("/leave"){
            val player = call.receive<Player>()
            val result =  Playground.leave(player)

            call.respond(
                status = HttpStatusCode.OK,
                message = result
            )
        }

        initFCM()
    }
}

private fun initFCM() {
    val serviceAccount = FileInputStream(
        "bored-passenger-firebase-adminsdk-lj7s7-23a6b54a95.json")

    val options: FirebaseOptions = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
        .setDatabaseUrl("https://bored-passenger.firebaseio.com")
        .build()
    FirebaseApp.initializeApp(options)
}