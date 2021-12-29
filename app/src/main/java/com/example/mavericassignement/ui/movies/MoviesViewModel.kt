package com.example.mavericassignement.ui.movies

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.example.mavericassignement.data.remote.api.model.Movie
import com.example.mavericassignement.reposotories.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val repo: MoviesRepository) : ViewModel() {
    suspend fun getMovies(trim: String?): Flow<PagingData<Movie.Search>> {
        return repo.getMovies()
    }



}