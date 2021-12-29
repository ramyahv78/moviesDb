package com.example.mavericassignement.reposotories

import androidx.paging.PagingSource
import com.example.mavericassignement.data.remote.api.ApiHelper
import com.example.mavericassignement.data.remote.api.model.Movie


class MoviesSource(
    private val apiHelper: ApiHelper,
   private var searchWord: String?
) : PagingSource<Int, Movie.Search>()  {

     override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie.Search> {
          return try {
               // Start refresh at page 1 if undefined.
               val nextPage = params.key ?: 1
               if(searchWord.isNullOrBlank()){
                    searchWord="Marvel"
               }
               val response = apiHelper.getMovies(nextPage,searchWord)
               val data=response.body() as Movie
               LoadResult.Page(
                    data = data.search,
                    prevKey = if (nextPage == 1) null else nextPage - 1,
                    nextKey = nextPage + 1
               )
          } catch (e: Exception) {
               LoadResult.Error(e)
          }
     }

}