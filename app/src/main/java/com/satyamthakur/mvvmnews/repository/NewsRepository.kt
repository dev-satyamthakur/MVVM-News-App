package com.satyamthakur.mvvmnews.repository

import com.satyamthakur.mvvmnews.api.RetrofitInstance
import com.satyamthakur.mvvmnews.db.ArticleDatabase

class NewsRepository(
    val db: ArticleDatabase
) {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

}