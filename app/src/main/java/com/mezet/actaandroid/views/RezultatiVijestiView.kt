package com.mezet.actaandroid.views

import com.mezet.actaandroid.models.rezultativijesti.RezultatiVijesti

interface RezultatiVijestiView {
    fun getRezultati(vijesti: RezultatiVijesti?)
}