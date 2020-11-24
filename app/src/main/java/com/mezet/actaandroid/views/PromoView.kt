package com.mezet.actaandroid.views

import com.mezet.actaandroid.models.promo.PromoPayload

interface PromoView {
    fun getPromoRespones(promoPayload: PromoPayload?)
}