package com.example.mavericassignement.ui.moviedetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.mavericassignement.R
import com.example.mavericassignement.data.remote.api.model.MovieDetails
import com.example.mavericassignement.databinding.FragmentMovieDetailsBinding
import com.example.mavericassignement.other.loadImagesWithGlide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailsFragment : Fragment(R.layout.fragment_movie_details) {
    private lateinit var binding: FragmentMovieDetailsBinding
    private val viewModel: MovieDetailsViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieDetailsBinding.bind(view)
        viewModel.getMovieDetails(arguments?.getString("imdb")!!)

        initObserver()
    }

    private fun initObserver() {
        viewModel.liveDataDetails.observe(viewLifecycleOwner, Observer { details ->
            initView(details)
        })
    }

    private fun initView(details: MovieDetails) {
        binding.apply {
            ivMoviePoster.loadImagesWithGlide(details.poster)
            tvMovieTitle.text = details.title
            tvYear.text = details.year
            tvActor.text = "Actor : ${details.actors}"
            tvPredictor.text = "Language : ${details.language}"
            tvWriter.text = "Writer : ${details.writer}"
            tvScore.text = "Score  \n\n ${details.metascore}"
            tvReview.text = "Review  \n\n ${details.imdbRating}"
            tvPopularity.text = "Released on \n \n ${details.released}"

        }
    }
}