package com.naveed.myandroidapp.view.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.naveed.myandroidapp.R
import com.naveed.myandroidapp.databinding.FragmentPopularMovieDetailBinding
import com.naveed.myandroidapp.extension.loadImage
import com.naveed.myandroidapp.model.Movies



/**
 * View/Fragment for Popular Movies Detail Screen
 */
class PopularMovieDetailFragment : Fragment() {

    private lateinit var binding : FragmentPopularMovieDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val movieSelected = arguments?.get("selectedMovie") as Movies

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_popular_movie_detail, container, false)
        binding.movie = movieSelected
        binding.imageView.loadImage(movieSelected.poster_path)
        return binding.root
    }

}