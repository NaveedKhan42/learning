package com.naveed.myandroidapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.naveed.myandroidapp.databinding.ShowListItemBinding
import com.naveed.myandroidapp.extension.loadImage
import com.naveed.myandroidapp.model.TVShow

/**
 * RecyclerView Adapter for the TV Shows Screen
 */
class PopularTVShowsAdapter(private var showsList: List<TVShow>) :
    RecyclerView.Adapter<PopularTVShowsAdapter.TVShowViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ShowListItemBinding.inflate(layoutInflater)
        return TVShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TVShowViewHolder, position: Int) {

        val tvShow:TVShow = showsList[position]
        holder.bind(tvShow)

    }

    override fun getItemCount() = showsList.size

    //Inner Class
    class TVShowViewHolder(val binding: ShowListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(tvShow:TVShow){
            binding.tvshow = tvShow
            binding.tvshowBanner.loadImage(tvShow.poster_path)
        }
    }

}