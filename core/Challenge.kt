package core

data class Challenge(
        val id: String,
        val gameId: String,
        val question: String,
        val correctAnswer: String
) {
        override fun toString(): String {
                return "Challenge(id='$id', question='$question', correctAnswer='$correctAnswer')"
        }
}