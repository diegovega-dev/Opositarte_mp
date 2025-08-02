package es.diego

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform