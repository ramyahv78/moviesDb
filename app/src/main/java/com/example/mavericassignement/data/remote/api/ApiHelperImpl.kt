package com.example.mavericassignement.data.remote.api

import com.example.mavericassignement.data.remote.api.model.Movie
import com.example.mavericassignement.data.remote.api.model.MovieDetails
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {
    override suspend fun getMovies(page: Int): Response<Movie> {
        return apiService.getMovies(page = page)
    }

    override suspend fun getMovieDetails(imdb: String): Response<MovieDetails> {
        return apiService.getMovieDetails(imdb = imdb)
    }


}