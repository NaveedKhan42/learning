package com.naveed.myandroidapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.naveed.myandroidapp.model.PopularMovies
import com.naveed.myandroidapp.network.TmdbApiEndPoints
import com.naveed.myandroidapp.network.RetrofitService
import retrofit2.Call
import retrofit2.Response

/**
 * Repository class for Movies : Uses Retrofit for data operations
 *
 */
class MoviesRepo {

    /**
     * Fetches movies data thru API using Retrofit
     */
    fun getPopularMovies() : LiveData<PopularMovies> {
        val apiResponse = MutableLiveData<PopularMovies>()
        val request = RetrofitService.buildService(TmdbApiEndPoints::class.java)
        val call = request.getPopularMovies()

        call.enqueue(object : retrofit2.Callback<PopularMovies> {
            override fun onResponse(call: Call<PopularMovies>, response: Response<PopularMovies>) {
                if (response.isSuccessful){
                    apiResponse.postValue(response.body())
                }
            }
            override fun onFailure(call: Call<PopularMovies>, t: Throwable) {
                t.printStackTrace()
            }
        })

        return apiResponse
    }
}