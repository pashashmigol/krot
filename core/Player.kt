package core

data class Player(
    val id: String,
    val nickName: String,
    val fcmToken: String,
    val lat: Float,
    val long: Float,
    val radius: Float = 0.0f
) {
    override fun toString(): String {
        return "Player(id='$id', nickName='$nickName')"
    }
}