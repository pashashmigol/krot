package core

data class Player(
    val id: String,
    val nickName: String,
    val location: Location,
    val fcmToken: String
) {
    data class Location(
        val lat: Float,
        val long: Float,
        val radius: Float = 0.0f
    ) {
        override fun toString(): String {
            return "$lat;$long;$radius"
        }
    }

    override fun toString(): String {
        return "Player(id='$id', nickName='$nickName', location=$location, fcmToken='$fcmToken')"
    }

    companion object {
        fun fromJson(json: String): Player{
            return Player(id = "", nickName = "", location = Location(lat = 0.0f, long = 0.0f, radius = 0.0f), fcmToken = "")
        }
    }
}