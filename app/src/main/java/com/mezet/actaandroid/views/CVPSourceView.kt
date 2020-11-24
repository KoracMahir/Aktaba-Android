package com.mezet.actaandroid.views

import com.mezet.actaandroid.models.cvp.CvpPayload

interface CVPSourceView {
    fun getCVP(cvpPayload: CvpPayload?)
    fun getSources(cvpPayload: CvpPayload?)
}