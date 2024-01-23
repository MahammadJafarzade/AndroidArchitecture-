package com.mahammadjafarzade.network.di

import com.google.gson.Gson
import com.mahammadjafarzade.network.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataLayerModule {
    @Provides
    @Singleton
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    @FlightAnnotation
    fun provideApiCLient(gson: Gson, @FlightAnnotation client: OkHttpClient): Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://65a7624794c2c5762da692dd.mockapi.io/api/v1/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
        return retrofit
    }

    @Provides
    @Singleton
    fun provideApiService( @FlightAnnotation retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    @FlightAnnotation
    fun provideOkHttpClient() {
        val client = OkHttpClient.Builder()

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        client
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
    }
}
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class FlightAnnotation