package es.diego.data

import es.diego.database.AppDatabase
import es.diego.database.Obra
import kotlinx.serialization.json.Json

class obrasJson( private val database: AppDatabase
) {
    suspend fun loadObras() {
        val jsonString = loadJsonFromResources()
        val obras: List<Obra> = Json.decodeFromString(jsonString)
        database.appDatabaseQueries.transaction {
            obras.forEach {
                database.appDatabaseQueries.insertAll(
                    id = it.id,
                    nombre = it.nombre,
                    autor = it.autor,
                    siglo = it.siglo,
                    estilo = it.estilo,
                    explicacion = it.explicacion,
                    perspectiva = it.perspectiva,
                    tipo = it.tipo,
                    foto = it.foto
                )
            }
        }
    }
}

expect fun loadJsonFromResources(): String