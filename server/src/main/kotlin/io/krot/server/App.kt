package io.krot.server

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
    }
}