import core.Answer
import core.Player
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializer

@ExperimentalSerializationApi
@Serializer(forClass = Player::class)
object PlayerSerializer

@ExperimentalSerializationApi
@Serializer(forClass = Answer::class)
object AnswerSerializer