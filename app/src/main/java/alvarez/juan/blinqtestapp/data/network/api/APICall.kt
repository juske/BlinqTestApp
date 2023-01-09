package alvarez.juan.blinqtestapp.data.network.api

import alvarez.juan.blinqtestapp.data.network.model.Request
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface APICall {

    @Headers("Accept: application/json")
    @POST("/")
    suspend fun sendRequest(@Body request: Request): String
}