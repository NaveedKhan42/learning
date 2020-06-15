package com.naveed.myandroidapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.naveed.myandroidapp.databinding.MovieListItemBinding
import com.naveed.myandroidapp.extension.loadImage
import com.naveed.myandroidapp.model.Movies

/**
 * RecyclerView Adapter for the Movies Screen
 */
class PopularMoviesAdapter(private val movieList: List<Movies>, val listener : OnMovieClickListener
        ) : RecyclerView.Adapter<PopularMoviesAdapter.MovieListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = MovieListItemBinding.inflate(layoutInflater)
        return MovieListViewHolder(binding)
    }


    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        val movie:Movies = movieList[position]
        holder.bind(movie)

        holder.itemView.setOnClickListener{
            listener.onClick(movie)
        }
    }


    override fun getItemCount(): Int {
        return movieList.size
    }

    class MovieListViewHolder(
        val binding: MovieListItemBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(movie:Movies){
            binding.movie = movie
            binding.movieBanner.loadImage(movie.poster_path)
        }
    }

    interface OnMovieClickListener{
        fun onClick(movie : Movies)
    }

}