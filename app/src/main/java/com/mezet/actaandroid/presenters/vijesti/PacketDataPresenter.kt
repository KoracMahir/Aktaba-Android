package com.mezet.actaandroid.presenters.vijesti

import android.util.Log
import com.mezet.actaandroid.fragments.TestirajBesplatnoFragment
import com.mezet.actaandroid.fragments.main.vijesti.search.SearchKategorijePrivredeFragment
import com.mezet.actaandroid.models.privreda.PrivredaKategorije
import com.mezet.actaandroid.models.testiraj_items.TestirajData
import com.mezet.actaandroid.services.RetrofitServices
import com.mezet.actaandroid.views.PacketDataView
import com.mezet.actaandroid.views.PrivredaView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PacketDataPresenter(context : TestirajBesplatnoFragment){
    val packetDataView = context as PacketDataView

    fun getPacketData(){
        Log.d("radili","uraso je u poziv")
        RetrofitServices.create()
            .getPacketData()
            .enqueue(object : Callback<TestirajData>{
                override fun onFailure(call: Call<TestirajData>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<TestirajData>,
                    response: Response<TestirajData>
                ) {
                    packetDataView.getPacketData(response.body())
                }
            })
    }
}