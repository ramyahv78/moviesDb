package com.example.mavericassignement.reposotories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.mavericassignement.data.remote.api.ApiHelper
import com.example.mavericassignement.data.remote.api.model.Movie
import com.example.mavericassignement.data.remote.api.model.MovieDetails
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class MoviesRepository @Inject constructor(private val apiHelper: ApiHelper) {


    suspend fun getMovies(): Flow<PagingData<Movie.Search>> =
        Pager(PagingConfig(pageSize = 20)) {
            MoviesSource(apiHelper)
        }.flow



   suspend fun getMovieDetails(imdb: String):Response<MovieDetails> = apiHelper.getMovieDetails(imdb)


}