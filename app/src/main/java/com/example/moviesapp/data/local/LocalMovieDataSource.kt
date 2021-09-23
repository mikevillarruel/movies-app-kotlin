package com.example.moviesapp.data.local

import com.example.moviesapp.data.model.MovieEntity
import com.example.moviesapp.data.model.MovieList
import com.example.moviesapp.data.model.toMovieList

class LocalMovieDataSource(private val movieDao: MovieDao) {
    suspend fun getUpcomingMovies(): MovieList {
        return movieDao.getAllMovies()
            .filter { movieEntity -> movieEntity.movie_type == "upcoming" }
            .toMovieList()
    }

    suspend fun getTopRatedMovies(): MovieList {
        return movieDao.getAllMovies()
            .filter { movieEntity -> movieEntity.movie_type == "toprated" }
            .toMovieList()
    }

    suspend fun getPopularMovies(): MovieList {
        return movieDao.getAllMovies()
            .filter { movieEntity -> movieEntity.movie_type == "popular" }
            .toMovieList()
    }

    suspend fun saveMovie(movie: MovieEntity) {
        movieDao.saveMovie(movie)
    }
}