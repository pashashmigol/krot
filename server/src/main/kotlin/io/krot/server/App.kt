package io.krot.server

import com.google.appengine.repackaged.com.google.api.client.googleapis.auth.oauth2.GoogleCredential
import com.google.appengine.repackaged.com.google.datastore.v1.client.DatastoreOptions
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
import java.io.FileInputStream
import com.google.appengine.repackaged.com.google.datastore.v1.client.DatastoreOptions.SCOPES
import java.util.*


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
        "/Users/pashashmigol/tests/krot/server/bored-passenger-firebase-adminsdk-lj7s7-23a6b54a95.json")

//    val googleCredential: GoogleCredential = GoogleCredential
//        .fromStream(FileInputStream("service-account.json"))
//        .createScoped(SCOPES)

    val options: FirebaseOptions = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
        .setDatabaseUrl("https://bored-passenger.firebaseio.com")
        .build()
    FirebaseApp.initializeApp(options)
}