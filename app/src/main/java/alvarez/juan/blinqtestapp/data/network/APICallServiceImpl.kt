package alvarez.juan.blinqtestapp.data.network

import alvarez.juan.blinqtestapp.data.network.api.APICall
import alvarez.juan.blinqtestapp.data.network.model.Request

class APICallServiceImpl(private val api: APICall): APICallService  {

    override suspend fun sendRequest(request: Request): String {
        return api.sendRequest(request)
    }
}