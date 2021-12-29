package com.example.mavericassignement.data.remote.api

import com.example.mavericassignement.data.remote.api.model.Movie
import com.example.mavericassignement.data.remote.api.model.MovieDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
    @GET("/")
    suspend fun getMovies(
        @Query("apikey") apiKey: String = "b9bd48a6",
        @Query("page") page: Int,
        @Query("s") search: String = "Marvel"
    ): Response<Movie>


    @GET("/")
    suspend fun getMovieDetails(
        @Query("apikey") apiKey: String? = "b9bd48a6",
        @Query("i") imdb: String
    ): Response<MovieDetails>
}