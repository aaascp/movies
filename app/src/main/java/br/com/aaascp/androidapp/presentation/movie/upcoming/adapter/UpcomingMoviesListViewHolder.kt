package br.com.aaascp.androidapp.presentation.movie.upcoming.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import br.com.aaascp.androidapp.R
import br.com.aaascp.androidapp.infra.source.local.entity.MovieDetails
import br.com.aaascp.androidapp.infra.source.local.entity.MovieUpcoming
import br.com.aaascp.androidapp.presentation.ViewHolderBase
import br.com.aaascp.androidapp.presentation.movie.details.MoviesDetailsActivity
import br.com.aaascp.androidapp.presentation.util.loadImageFromApi
import kotlinx.android.synthetic.main.row_upcoming_movie_item.view.*

class UpcomingMoviesListViewHolder private constructor(view: View) : ViewHolderBase<MovieUpcoming>(view) {

    companion object {
        fun create(parent: ViewGroup): UpcomingMoviesListViewHolder {
            val inflatedView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.row_upcoming_movie_item, parent, false)
            return UpcomingMoviesListViewHolder(inflatedView)
        }
    }

    private val root: View = view.root
    private val image: ImageView = view.image
    private val title: TextView = view.title
    private val releaseDate: TextView = view.releaseDate

    override fun bind(item: MovieUpcoming) {
        item.posterPath?.let {
            loadImageFromApi(image, item.posterPath)
        }

        title.text = item.title
        bindReleaseDate(
                root.context.applicationContext,
                item.releaseDate)

        root.setOnClickListener {
            MoviesDetailsActivity.start(
                    it.context,
                    item.id)
        }
    }

    private fun bindReleaseDate(context: Context, date: String) {
        val releaseDateFormat =  context.getString(R.string.upcoming_movie_release_date)

        releaseDate.text =
                String.format(releaseDateFormat, date)
    }
}