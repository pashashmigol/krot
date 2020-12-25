package io.krot.server

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport
import com.google.api.client.http.HttpRequestInitializer
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.services.sheets.v4.Sheets
import com.google.api.services.sheets.v4.SheetsScopes
import com.google.auth.http.HttpCredentialsAdapter
import core.Challenge
import core.Settings.CHALLENGES_FILE_COLUMNS
import core.Settings.CHALLENGES_FILE_ID_GOOGLE_DOC


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

        val allSheetsRequest = sheets.spreadsheets()
            .values().get(CHALLENGES_FILE_ID_GOOGLE_DOC, CHALLENGES_FILE_COLUMNS)

        allChallenges = allSheetsRequest.execute().getValues()
            .toRawEntries()
            .map { it.toChallenges() }

        println("GoogleSheetsQuestionsProvider.init(); loaded ${allChallenges.size} challenges")
    }


    override fun obtainNewChallenge(gameId: String, index: Int): Challenge {
        val challenge = allChallenges.shuffled().first().copy(gameId = gameId)
        println("GoogleSheetsQuestionsProvider.obtainNewChallenge(); challenge: $challenge")
        return challenge
    }
}

private fun Map<String, Any>.toChallenges() = Challenge(
    id = stringFor("id"),
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