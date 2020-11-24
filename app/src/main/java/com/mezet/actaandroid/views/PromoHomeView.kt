package com.mezet.actaandroid.views

import com.mezet.actaandroid.models.promo.PromoPayload
import com.mezet.actaandroid.models.promohomepage.PromoHome

interface PromoHomeView {
    fun getPromoRespones(promoHome: PromoHome?)
}