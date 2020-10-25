package com.mezet.actaandroid.views

import com.mezet.actaandroid.models.Vijesti
import com.mezet.actaandroid.models.mostrecentnews.MostRecentNews

interface VijestiView {
    fun onVijesti(mostRecentNews: MostRecentNews?)
    fun onVijestiFailiuer(string : String)
}