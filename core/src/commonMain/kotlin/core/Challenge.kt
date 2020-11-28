package core

data class Challenge(
        val id: String,
        val gameId: String,
        val question: String,
        val correctAnswer: String
) {
}