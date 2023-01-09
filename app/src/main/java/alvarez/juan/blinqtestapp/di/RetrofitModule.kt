package alvarez.juan.blinqtestapp.di

import alvarez.juan.blinqtestapp.data.network.APICallService
import alvarez.juan.blinqtestapp.data.network.APICallServiceImpl
import alvarez.juan.blinqtestapp.data.network.api.APICall
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        val httpLoggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        val httpClientBuilder = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor)

        return Retrofit.Builder()
            .baseUrl("https://us-central1-blinkapp-684c1.cloudfunctions.net/fakeAuth")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClientBuilder.build())
            .build()
    }

    @Singleton
    @Provides
    fun provideWebService(retrofit: Retrofit): APICall = retrofit.create(APICall::class.java)

    @Singleton
    @Provides
    fun provideRetrofitService(
        api: APICall
    ): APICallService {
        return APICallServiceImpl(api)
    }
}