package com.example.moviesapp.data.model

import com.google.gson.annotations.SerializedName

data class Movie(
    val id: Int = -1,
    // @SerializedName("adult")
    val adult: Boolean = false,
    val backdropPath: String = "",
    val genreIDS: List<Int> = listOf(),
    val originalLanguage: String = "",
    val originalTitle: String = "",
    val overview: String = "",
    val popularity: Double = -1.0,
    val posterPath: String = "",
    val releaseDate: String = "",
    val title: String = "",
    val video: Boolean = false,
    val voteAverage: Double = -1.0,
    val voteCount: Long = -1
)

data class MovieList(val results: List<Movie> = listOf())
