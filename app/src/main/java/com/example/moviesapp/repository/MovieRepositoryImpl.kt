package com.example.moviesapp.repository

import com.example.moviesapp.core.InternetCheck
import com.example.moviesapp.data.local.LocalMovieDataSource
import com.example.moviesapp.data.model.MovieList
import com.example.moviesapp.data.model.toMovieEntity
import com.example.moviesapp.data.remote.RemoteMovieDataSource

class MovieRepositoryImpl(
    private val dataSourceRemote: RemoteMovieDataSource,
    private val dataSourceLocal: LocalMovieDataSource
) : MovieRepository {

    override suspend fun getUpcomingMovies(): MovieList {
        if (InternetCheck.isNetworkAvailable()) {
            dataSourceRemote.getUpcomingMovies().results.forEach { movie ->
                dataSourceLocal.saveMovie(movie.toMovieEntity("upcoming"))
            }
        }
        return dataSourceLocal.getUpcomingMovies()
    }

    override suspend fun getTopRatedMovies(): MovieList {
        if (InternetCheck.isNetworkAvailable()) {
            dataSourceRemote.getTopRatedMovies().results.forEach { movie ->
                dataSourceLocal.saveMovie(movie.toMovieEntity("toprated"))
            }
        }
        return dataSourceLocal.getTopRatedMovies()
    }

    override suspend fun getPopularMovies(): MovieList {
        if (InternetCheck.isNetworkAvailable()) {
            dataSourceRemote.getPopularMovies().results.forEach { movie ->
                dataSourceLocal.saveMovie(movie.toMovieEntity("popular"))
            }
        }
        return dataSourceLocal.getPopularMovies()
    }

}