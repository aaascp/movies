package br.com.aaascp.androidapp.infra.source.remote.body

import br.com.aaascp.androidapp.infra.source.remote.body.movie.MovieDetailsResponseBody
import br.com.aaascp.androidapp.infra.source.remote.body.movie.MovieUpcomingResponseBody

typealias MovieUpcomingResponse = ResultsResponseBody<List<MovieUpcomingResponseBody>>
typealias MovieDetailsResponse = MovieDetailsResponseBody
