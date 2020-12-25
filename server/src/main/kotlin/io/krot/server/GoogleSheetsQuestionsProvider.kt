package io.krot.server

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport
import com.google.api.client.http.HttpRequestInitializer
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.services.sheets.v4.Sheets
import com.google.api.services.sheets.v4.SheetsScopes
import com.google.auth.http.HttpCredentialsAdapter
import core.Challenge


class GoogleSheetsQuestionsProvider : QuestionProvider {

    private val allChallenges: List<Challenge>

    init {
        val transport = GoogleNetHttpTransport.newTrustedTransport()
        val jacksonFactory = JacksonFactory.getDefaultInstance()
        val scopes = listOf(SheetsScopes.SPREADSHEETS_READONLY)
        val local: HttpRequestInitializer by lazy {
            HttpCredentialsAdapter(credentials.createScoped(scopes))
        }
        val sheets = Sheets.Builder(transport, jacksonFactory, local).build()
        println("GoogleSheetsQuestionsProvider.init()-1; sheets: $sheets")

        val allSheetsRequest = sheets.spreadsheets()
            .values().get("10v3Vh2NdJwpfCrYiqYmPM7cAxfbXsjrmGn0ovqmhNdM", "A:C")
        println("GoogleSheetsQuestionsProvider.init()-2; allSheetsRequest: $sheets")

        allChallenges = allSheetsRequest.execute().getValues()
            .toRawEntries()
            .map { it.toChallenges() }

        println("GoogleSheetsQuestionsProvider.init()-3; allChallenges: $allChallenges")
    }


    override fun obtainNewChallenge(gameId: String, index: Int): Challenge {
        val challenge = allChallenges.shuffled().first().copy(gameId = gameId)
        println("GoogleSheetsQuestionsProvider.obtainNewChallenge(); challenge: $challenge")
        return challenge
    }
}

private fun Map<String, Any>.toChallenges() = Challenge(
    id = stringFor("Id"),
    gameId = "",
    question = stringFor("question"),
    correctAnswer = stringFor("answer"),
)

private fun List<List<Any>>.toRawEntries(): List<Map<String, Any>> {
    val headers = first().map { it as String }
    val rows = drop(1)
    return rows.map { row -> headers.zip(row).toMap() }
}

private fun Map<String, Any>.stringFor(key: String) = (this[key] as? String) ?: ""
private fun Map<String, Any>.longFor(key: String) = stringFor(key).toLongOrNull() ?: -1