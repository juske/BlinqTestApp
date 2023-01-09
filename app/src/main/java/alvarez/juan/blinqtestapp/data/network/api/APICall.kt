package alvarez.juan.blinqtestapp.data.network.api

import alvarez.juan.blinqtestapp.data.network.model.Request
import alvarez.juan.blinqtestapp.util.State
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface APICall {

    @Headers(
        "Content-Type: text/plain",
        "charset: utf-8")
    @POST("/")
    suspend fun sendRequest(@Body request: Request): Response<String>
}