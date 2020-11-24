package com.mezet.actaandroid.views

import com.mezet.actaandroid.models.pobjedenatenderima.TenderWinners
import com.mezet.actaandroid.models.publishedtenders.PublishedTenders

interface PobjedeTenderiView {
    fun getWinners(winners: TenderWinners?)
}