package com.mezet.actaandroid.views

import com.mezet.actaandroid.models.kursnalista.KursnaLista

interface KursnaListaView {
    fun getKursnaLista(kursnaLista: KursnaLista?)
}