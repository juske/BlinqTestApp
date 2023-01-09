package alvarez.juan.blinqtestapp.util

sealed class State<out T> {
    data class Success<T>(val data: T) : State<T>()
    data class Error<T>(val data: T? = null, val exception: Exception? = null) : State<T>()
    data class Loading<T>(val showLoader: Boolean) : State<T>()
}