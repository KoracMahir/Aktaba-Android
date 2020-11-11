package com.mezet.actaandroid.services

import com.mezet.actaandroid.models.LoginResponse
import com.mezet.actaandroid.models.UpitPayload
import com.mezet.actaandroid.models.Vijesti
import com.mezet.actaandroid.models.company.CompanyAutocompletePayload
import com.mezet.actaandroid.models.company.CompanyPayload
import com.mezet.actaandroid.models.izdvojeni.IzdvojenoPayload
import com.mezet.actaandroid.models.kojepratim.KojePratimPayload
import com.mezet.actaandroid.models.mojprofil.ClientProfile
import com.mezet.actaandroid.models.mostrecentnews.MostRecentNews
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

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

    //LOGIN
    @GET("/Services/Login")
    fun Login(@Query("uname") uname : String
                ,@Query("password")password:String): Call<LoginResponse>

    //USER PROFILE

    @GET("/Services/getClientProfile")
    fun getClientProfile(@Header("Authorization")token:String): Call<ClientProfile>

    @GET("/Services/GetCompanyData")
    fun getCompanyData(@Query("companyId") companyid : Int, @Header("Authorization")token:String):Call<CompanyPayload>

    @GET("/Services/GetCompanyAutocompleteByName")
    fun getCompanyAutoComplete(@Query("term") term : String): Call<CompanyAutocompletePayload>

    @GET("/Services/GetCompanyByIdNumberAutocomplete")
    fun getCompanyIDAutoComplete(@Query("term") term : String): Call<CompanyAutocompletePayload>

    @GET("/Services/ClientFavoriteCompanies?limit=1")
    fun getFollowedKompanije(@Header("Authorization")token:String): Call<KojePratimPayload>

    @GET("/Services/ClientFavorites?limit=1")
    fun getIzdvojeno(@Header("Authorization")token:String): Call<IzdvojenoPayload>

    @GET("/Services/ClientSendComment")
    fun sendUpit(@Query("comment") comment : String,@Header("Authorization")token:String): Call<UpitPayload>

    //REGISTAR

    @GET("/Services/getCompaniesCount")
    fun getCompaniesCount(): Call<Int>

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