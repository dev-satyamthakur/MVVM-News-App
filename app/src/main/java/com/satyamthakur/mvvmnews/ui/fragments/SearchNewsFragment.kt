package com.satyamthakur.mvvmnews.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.satyamthakur.mvvmnews.NewsActivity
import com.satyamthakur.mvvmnews.R
import com.satyamthakur.mvvmnews.ui.NewsViewModel

class SearchNewsFragment: Fragment(R.layout.fragment_search_news) {

    lateinit var viewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
    }
}