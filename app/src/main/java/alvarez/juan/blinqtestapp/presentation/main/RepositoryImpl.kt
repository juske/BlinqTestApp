package alvarez.juan.blinqtestapp.presentation.main

import alvarez.juan.blinqtestapp.data.network.Repository
import alvarez.juan.blinqtestapp.data.network.api.APICall
import alvarez.juan.blinqtestapp.data.network.model.Request
import alvarez.juan.blinqtestapp.util.State

class RepositoryImpl(private val api: APICall): Repository {

    override suspend fun sendRequest(request: Request): State<String> {
        return try {
            val response = api.sendRequest(request)
            val result = response.body()
            if (response.isSuccessful && result != null) {
                State.Success(result)
            } else {
                State.Error(response.message())
            }
        } catch(e: Exception) {
            State.Error(e.message ?: "An error occured")
        }
    }
}