package com.weblogging2.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.delay

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get("/api/v1") {
            call.application.environment.log.info("Hello from /api/v1!")
            call.respondText("Hello, world!")
        }
        get("/api/v2") {
            call.respondText("Bye!")
        }
        get("/api/show-error") {
            call.application.environment.log.info("will throw exception")
            throw Exception("Error from /api/show-error")
        }
        get("/api/delay") {
            val delayTime = 1000L
            delay(delayTime)
            call.respondText("has delay $delayTime ms")
        }
    }
}
