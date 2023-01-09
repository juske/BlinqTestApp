package alvarez.juan.blinqtestapp.data.network

import alvarez.juan.blinqtestapp.data.network.model.Request
import alvarez.juan.blinqtestapp.util.State

interface Repository {
    suspend fun sendRequest(request: Request): State<String>
}