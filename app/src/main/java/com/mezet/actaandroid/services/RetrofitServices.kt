package com.mezet.actaandroid.services

import com.mezet.actaandroid.models.Vijesti
import com.mezet.actaandroid.models.mostrecentnews.MostRecentNews
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitServices{

    @GET("/Services/mostrecentnews")
    fun getMostRecentNews(): Call<MostRecentNews>

    @GET("/Services/MostRecentNews?categoryId=1")
    fun getVijesti(): Call<MostRecentNews>

    @GET("/Services/MostRecentNews?categoryId=2")
    fun getInvesticije(): Call<MostRecentNews>

    @GET("/Services/MostRecentNews?categoryId=66")
    fun getAnalize(): Call<MostRecentNews>

    @GET("/Services/MostRecentNews?categoryId=4")
    fun getEU(): Call<MostRecentNews>

    @GET("/Services/MostRecentNews?categoryId=5")
    fun getNajave(): Call<MostRecentNews>


    //VIJESTI

    @GET("/Services/MostRecentNews?categoryId=9")
    fun getBiH(): Call<MostRecentNews>

    @GET("/Services/MostRecentNews?categoryId=10")
    fun getRegija(): Call<MostRecentNews>

    @GET("/Services/MostRecentNews?categoryId=11")
    fun getSvijet(): Call<MostRecentNews>

    //INVESTICIJE

    @GET("/Services/MostRecentNews?categoryId=12")
    fun getProjekti(): Call<MostRecentNews>

    @GET("/Services/MostRecentNews?categoryId=13")
    fun getUrbanizam(): Call<MostRecentNews>

    @GET("/Services/MostRecentNews?categoryId=14")
    fun getNekretnine(): Call<MostRecentNews>

    @GET("/Services/MostRecentNews?categoryId=15")
    fun getImovina(): Call<MostRecentNews>

    @GET("/Services/MostRecentNews?categoryId=16")
    fun getPrivatizacija(): Call<MostRecentNews>

    companion object{
        fun create():RetrofitServices{
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://mservices.acta.ba")
                .build()
            return retrofit.create(RetrofitServices::class.java)
        }
    }
}