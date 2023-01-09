package alvarez.juan.blinqtestapp.data.network

import alvarez.juan.blinqtestapp.data.network.model.Request

interface APICallService {
    suspend fun sendRequest(request: Request): String
}