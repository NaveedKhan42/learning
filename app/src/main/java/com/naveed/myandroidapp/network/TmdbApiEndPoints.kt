package com.naveed.myandroidapp.network

import com.naveed.myandroidapp.model.PopularMovies
import com.naveed.myandroidapp.model.PopularTVShows
import retrofit2.Call
import retrofit2.http.GET

/**
 * Retrofit Interface: holds the different RESTful API functions signature and URI path
 *
 */
interface TmdbApiEndPoints {

    /**
     * Fetches Popular Movies
     */
    @GET("/3/movie/popular")
    fun getPopularMovies(): Call<PopularMovies>

    /**
     * Fetches TV Shows
     */
    @GET("3/tv/popular")
    fun getPopularTVShows(): Call<PopularTVShows>
}