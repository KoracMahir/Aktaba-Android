package com.mezet.actaandroid.views

import android.content.Context
import com.mezet.actaandroid.models.Vijesti
import com.mezet.actaandroid.models.mostrecentnews.MostRecentNews

interface MostRecentNewsView {
    fun onMostRecentNews(mostRecentNews: MostRecentNews?)
    fun onFailiuer(string : String)
    fun getContext() :Context?
}