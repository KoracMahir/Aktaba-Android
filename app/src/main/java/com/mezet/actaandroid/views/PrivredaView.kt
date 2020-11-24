package com.mezet.actaandroid.views

import com.mezet.actaandroid.models.privreda.PrivredaKategorije

interface PrivredaView {
    fun getPrivredaCategories(privredaKategorije: PrivredaKategorije?)
}