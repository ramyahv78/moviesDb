package com.example.mavericassignement.ui.moviedetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.compose.NamedNavArgument
import androidx.navigation.compose.navArgument
import com.example.mavericassignement.data.remote.api.model.MovieDetails
import com.example.mavericassignement.reposotories.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(private val repo: MoviesRepository) : ViewModel() {
    private val livData = MutableLiveData<MovieDetails>()
    val liveDataDetails: MutableLiveData<MovieDetails> get() = livData

    fun getMovieDetails(imdb: String) {
        viewModelScope.launch {
            repo.getMovieDetails(imdb).let { response ->
                if (response.isSuccessful) {
                    livData.postValue(response.body())
                }
            }

        }
    }

}