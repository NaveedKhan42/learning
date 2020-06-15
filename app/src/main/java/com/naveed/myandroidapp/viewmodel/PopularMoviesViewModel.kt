package com.naveed.myandroidapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.naveed.myandroidapp.model.PopularMovies
import com.naveed.myandroidapp.repository.MoviesRepo

/**
 * PopularMoviesViewModel used for fetching of movies data from TMDB
 */
class PopularMoviesViewModel() : ViewModel() {

    private val moviesRepo = MoviesRepo()

    fun getPopularMovies(): LiveData<PopularMovies>{
        val movies : LiveData<PopularMovies> = moviesRepo.getPopularMovies()
        Log.d("Movies", "${movies.value.toString()}" )
        return movies
    }
}