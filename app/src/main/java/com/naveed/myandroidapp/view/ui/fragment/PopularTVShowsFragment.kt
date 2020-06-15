package com.naveed.myandroidapp.view.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.naveed.myandroidapp.R
import com.naveed.myandroidapp.databinding.FragmentTvshowsBinding
import com.naveed.myandroidapp.view.adapter.PopularTVShowsAdapter
import com.naveed.myandroidapp.viewmodel.PopularTVShowsViewModel


/**
 * View/Fragment for Popular TV Shows List Screen
 */
class PopularTVShowsFragment : Fragment() {

    private var viewModel = PopularTVShowsViewModel()
    private lateinit var adapter: PopularTVShowsAdapter
    private lateinit var binding: FragmentTvshowsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_tvshows,
            container,
            false
        )

        binding.isLoading = true
        viewModel = ViewModelProvider(this).get(PopularTVShowsViewModel::class.java)
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("TVShowFragment", "Inside onViewCreated()")

        viewModel.getPopularTVShows().observe(viewLifecycleOwner, Observer {
            adapter = PopularTVShowsAdapter(it.results)
            binding.isLoading = false
            binding.adapter = adapter
        })
    }

}
