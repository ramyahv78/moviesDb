package com.example.mavericassignement.ui.movies

import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.mavericassignement.ui.movies.adapter.MovieListAdapter
import com.example.mavericassignement.R
import com.example.mavericassignement.databinding.FragmentMoviesBinding
import com.example.mavericassignement.ui.movies.adapter.Listener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FragmentMovies : Fragment(R.layout.fragment_movies), Listener {
    private lateinit var binding: FragmentMoviesBinding
    private var adapter: MovieListAdapter? = null
    private val moviesViewModel: MoviesViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMoviesBinding.bind(view)
        initView()
        initObservers()
    }

    private fun initObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            moviesViewModel.getMovies("Marvel").collectLatest { movies ->
                adapter?.submitData(movies)
            }
        }
        binding.search.doOnTextChanged { text, start, before, count ->
            viewLifecycleOwner.lifecycleScope.launch {
                moviesViewModel.getMovies(text.toString().trim()).collectLatest { movies ->
                    adapter?.submitData(movies)
                }
            }
        }
    }

    private fun initView() {
        adapter = MovieListAdapter(this)
        binding.rvMovies.adapter = this.adapter

    }

    override fun openDetails(imdbID: String) {
        val bundel = Bundle()
        bundel.putString("imdb", imdbID)
        findNavController().navigate(R.id.action_fragmentMovies_to_movieDetailsFragment, bundel)
    }


}