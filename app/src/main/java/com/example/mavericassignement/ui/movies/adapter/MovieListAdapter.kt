package com.example.mavericassignement.ui.movies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mavericassignement.data.remote.api.model.Movie
import com.example.mavericassignement.databinding.MovieItemBinding
import com.example.mavericassignement.other.loadImagesWithGlide


class MovieListAdapter(val listener: Listener) : PagingDataAdapter<Movie.Search, MovieListAdapter.MovieViewHolder>(
    MovieComparator
) {

    object MovieComparator : DiffUtil.ItemCallback<Movie.Search>() {
        override fun areItemsTheSame(oldItem: Movie.Search, newItem: Movie.Search): Boolean {
            // Id is unique.
            return oldItem.imdbID == newItem.imdbID
        }

        override fun areContentsTheSame(oldItem: Movie.Search, newItem: Movie.Search): Boolean {
            return oldItem == newItem
        }
    }

    class MovieViewHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.binding.tvMovieName.text = getItem(position)?.title
        holder.binding.ivMoviePoster.loadImagesWithGlide(getItem(position)?.poster!!)
        holder.itemView.setOnClickListener {
            listener.openDetails(getItem(position)!!.imdbID!!)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            MovieItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,false)
        )
    }
}