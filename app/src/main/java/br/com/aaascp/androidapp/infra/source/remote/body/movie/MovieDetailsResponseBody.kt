package br.com.aaascp.androidapp.infra.source.remote.body.movie

import com.google.gson.annotations.SerializedName

data class GenreResponseBody(
        val id: Int,
        val name: String
)

data class MovieDetailsResponseBody(
        val id: Int,
        val genres: List<GenreResponseBody>,
        val title: String,
        val overview: String,
        @SerializedName("poster_path")
        val posterPath: String,
        @SerializedName("release_date")
        val releaseDate: String
)