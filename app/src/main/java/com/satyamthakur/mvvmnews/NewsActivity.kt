package com.satyamthakur.mvvmnews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.satyamthakur.mvvmnews.R
import com.satyamthakur.mvvmnews.databinding.ActivityNewsBinding
import com.satyamthakur.mvvmnews.db.ArticleDatabase
import com.satyamthakur.mvvmnews.repository.NewsRepository
import com.satyamthakur.mvvmnews.ui.NewsViewModel
import com.satyamthakur.mvvmnews.ui.NewsViewModelProviderFactory

class NewsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsBinding
    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(repository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory)
            .get(NewsViewModel::class.java)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.news_nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavigationView.setupWithNavController(navController)

    }
}