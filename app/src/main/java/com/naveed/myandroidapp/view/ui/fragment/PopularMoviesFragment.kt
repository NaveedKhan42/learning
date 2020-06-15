package com.naveed.myandroidapp.view.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.naveed.myandroidapp.R
import com.naveed.myandroidapp.databinding.FragmentPopularBinding
import com.naveed.myandroidapp.model.Movies
import com.naveed.myandroidapp.view.adapter.PopularMoviesAdapter
import com.naveed.myandroidapp.viewmodel.PopularMoviesViewModel


/**
 * View/Fragment for Popular Movies List Screen
 */
class PopularMoviesFragment : Fragment(), PopularMoviesAdapter.OnMovieClickListener {

    private var popularViewModel = PopularMoviesViewModel()
    private lateinit var popularMoviesAdapter: PopularMoviesAdapter
    private lateinit var popularBinder : FragmentPopularBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        popularBinder = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_popular,
                container,
                false
        )

        popularBinder.isLoading =true
        popularViewModel = ViewModelProvider(this).get(PopularMoviesViewModel::class.java)
        popularBinder.viewModel = popularViewModel

        return popularBinder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        popularViewModel.getPopularMovies().observe(viewLifecycleOwner, Observer {
            popularMoviesAdapter = PopularMoviesAdapter(it.results, this)
            popularBinder.isLoading = false
            popularBinder.adapter = popularMoviesAdapter
        })
    }

    override fun onClick(movie: Movies) {
        val movieBundle  = Bundle().apply {
            putParcelable("selectedMovie", movie)
        }
        findNavController().navigate(R.id.action_nav_popular_to_popularMovieDetailFragment, movieBundle)
    }
}
