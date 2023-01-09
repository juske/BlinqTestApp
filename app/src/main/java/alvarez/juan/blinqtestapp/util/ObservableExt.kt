package alvarez.juan.blinqtestapp.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

/**
 * Extension function for observers on Lifecycle Owner
 */
fun <T> LifecycleOwner.observe(liveData: LiveData<T>, action: (t: T) -> Unit) {
    liveData.observe(this) { it?.let { t -> action(t) } }
}
