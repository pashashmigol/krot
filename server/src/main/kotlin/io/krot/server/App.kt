package io.krot.server

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*


fun Application.main() {
    routing {
        get("/status") {
            call.respond("Server is running!")
        }
    }
}