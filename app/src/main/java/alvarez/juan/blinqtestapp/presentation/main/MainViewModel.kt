package alvarez.juan.blinqtestapp.presentation.main

import alvarez.juan.blinqtestapp.data.network.Repository
import alvarez.juan.blinqtestapp.data.network.model.Request
import alvarez.juan.blinqtestapp.util.State
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository,
): ViewModel() {

    private val _requestInvitation = MutableLiveData<String>()
    val requestInvitation: LiveData<String> get() = _requestInvitation

    fun postRequest(request: Request) {
        viewModelScope.launch(Dispatchers.Main) {
            when(repository.sendRequest(request)) {
                is State.Error -> _requestInvitation.value = "Error"
                is State.Success -> _requestInvitation.value = "success"
                else -> {}
            }
        }
    }
}