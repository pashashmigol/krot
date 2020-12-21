package core

sealed class Res<out T> {
    class Success<T>(val data: T) : Res<T>() {
        override fun toString() = "Success(data=$data)"
    }

    class Error(val message: String) : Res<Nothing>(){
        override fun toString() = "Error(message='$message')"
    }

    inline fun dealWithError(onError: (Error) -> Nothing): T {
        when (this) {
            is Success -> return data
            is Error -> {
                onError(this)
            }
        }
    }
}