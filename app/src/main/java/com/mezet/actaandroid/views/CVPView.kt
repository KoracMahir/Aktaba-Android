package com.mezet.actaandroid.views

import com.mezet.actaandroid.models.cvp.CvpPayload

interface CVPView {
    fun getCVP(cvpPayload: CvpPayload?)
}