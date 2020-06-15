package com.naveed.myandroidapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.naveed.myandroidapp.model.PopularTVShows
import com.naveed.myandroidapp.repository.TVShowsRepo

/**
 * PopularTVShowsViewModel used for fetching of tv shows data from TMDB
 */
class PopularTVShowsViewModel : ViewModel() {

    private val tvShowsRepo = TVShowsRepo()

    fun getPopularTVShows(): LiveData<PopularTVShows>{
        val tvShows : LiveData<PopularTVShows> = tvShowsRepo.getPopularTVShows()
        Log.d("TVShows", "${tvShows.value.toString()}" )
        return tvShows
    }

}