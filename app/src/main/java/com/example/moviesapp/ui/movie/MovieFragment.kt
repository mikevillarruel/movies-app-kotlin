package com.example.moviesapp.ui.movie

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.moviesapp.R
import com.example.moviesapp.databinding.FragmentMovieBinding

class MovieFragment : Fragment(R.layout.fragment_movie) {

    private lateinit var binding: FragmentMovieBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieBinding.bind(view)
    }

}