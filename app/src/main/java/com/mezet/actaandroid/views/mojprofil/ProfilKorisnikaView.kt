package com.mezet.actaandroid.views.mojprofil

import com.mezet.actaandroid.models.mojprofil.Client

interface ProfilKorisnikaView {
    fun getClient(client:Client?)
    fun getClientFax(fax:String)
    fun getCompanyId(id:Int)
}