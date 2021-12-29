package com.example.mavericassignement.data.remote.api

import com.example.mavericassignement.data.remote.api.model.Movie
import com.example.mavericassignement.data.remote.api.model.MovieDetails
import retrofit2.Response

interface ApiHelper {
    suspend fun getMovies(page: Int, searchWord: String?): Response<Movie>
    suspend fun getMovieDetails(imdb: String): Response<MovieDetails>
}