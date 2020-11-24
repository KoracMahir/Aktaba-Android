package com.mezet.actaandroid.views

import com.mezet.actaandroid.models.promohomepage.PromoHome
import com.mezet.actaandroid.models.promokategorije.PromoKategorije

interface PromoKategorijeView {
    fun getPromoRespones(promoKategorije: PromoKategorije?)
}