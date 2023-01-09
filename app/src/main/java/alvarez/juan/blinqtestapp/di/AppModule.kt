package alvarez.juan.blinqtestapp.di

import alvarez.juan.blinqtestapp.data.network.Repository
import alvarez.juan.blinqtestapp.data.network.api.APICall
import alvarez.juan.blinqtestapp.presentation.main.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
private object AppModule {
    @Singleton
    @Provides
    fun provideRepository(api: APICall): Repository = RepositoryImpl(api)
}