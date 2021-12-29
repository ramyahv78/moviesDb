package com.example.mavericassignement.data.remote.api

import androidx.paging.PagingData
import com.example.mavericassignement.data.remote.api.model.Movie
import com.example.mavericassignement.data.remote.api.model.MovieDetails
import com.example.mavericassignement.reposotories.SearchedMovies
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface ApiHelper {
    suspend fun getMovies(page: Int): Response<Movie>
    suspend fun getMovieDetails(imdb: String): Response<MovieDetails>
}