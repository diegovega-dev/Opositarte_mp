package es.diego.data

import android.content.Context

lateinit var appContext: Context

actual fun loadJsonFromResources(): String {
    return appContext.assets.open("obras.json").bufferedReader().use { it.readText() }
}