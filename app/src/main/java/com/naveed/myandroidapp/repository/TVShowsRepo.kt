package com.naveed.myandroidapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.naveed.myandroidapp.model.PopularTVShows
import com.naveed.myandroidapp.network.TmdbApiEndPoints
import com.naveed.myandroidapp.network.RetrofitService
import retrofit2.Call
import retrofit2.Response

/**
 * Repository class for TV Shows : Uses Retrofit for data operations
 *
 */
class TVShowsRepo {

    /**
     * Fetches TV Shows data thru API using Retrofit
     */
    fun getPopularTVShows() : LiveData<PopularTVShows> {
        val apiResponse = MutableLiveData<PopularTVShows>()
        val request = RetrofitService.buildService(TmdbApiEndPoints::class.java)
        val call = request.getPopularTVShows()

        call.enqueue(object : retrofit2.Callback<PopularTVShows> {
            override fun onResponse(call: Call<PopularTVShows>, response: Response<PopularTVShows>) {
                if (response.isSuccessful){
                    apiResponse.postValue(response.body())
                }
            }
            override fun onFailure(call: Call<PopularTVShows>, t: Throwable) {
                t.printStackTrace()
            }
        })

        return apiResponse
    }

}