package com.naveed.myandroidapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Data Class: holds the list of TV Shows
 */
data class PopularTVShows(
    val results: List<TVShow>
)

/**
 * Data class: describes TV Show object structure
 */
@Parcelize
data class TVShow(
    val backdrop_path: String,
    val first_air_date: String,
    val genre_ids: List<Int>,
    val id: Int,
    val name: String,
    val origin_country: List<String>,
    val original_language: String,
    val original_name: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val vote_average: Double,
    val vote_count: Int
) : Parcelable