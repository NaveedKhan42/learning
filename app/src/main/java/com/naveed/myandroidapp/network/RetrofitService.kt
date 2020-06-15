package com.naveed.myandroidapp.network

import com.naveed.myandroidapp.network.Definitions.API_KEY
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Retrofit Service class that builds the Base Client which is used for different API Calls
 */
object RetrofitService {

    private const val BASE_URL = "https://api.themoviedb.org/"

    private val client = OkHttpClient().newBuilder().addInterceptor{ chain ->
            var request: Request = chain.request()
            var url = request.url().newBuilder().addQueryParameter("api_key", API_KEY).build()
            request = request.newBuilder().url(url).build()
            chain.proceed(request)
    }.build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun<T> buildService(service: Class<T>) : T{
        return retrofit.create(service)
    }

}