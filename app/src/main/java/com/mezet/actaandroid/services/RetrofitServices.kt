package com.mezet.actaandroid.services

import com.mezet.actaandroid.fragments.main.Registar
import com.mezet.actaandroid.models.LoginResponse
import com.mezet.actaandroid.models.Search
import com.mezet.actaandroid.models.UpitPayload
import com.mezet.actaandroid.models.autocompletecountry.AutocompleteCountry
import com.mezet.actaandroid.models.berza.Berza
import com.mezet.actaandroid.models.company.CompanyAutocompletePayload
import com.mezet.actaandroid.models.company.CompanyPayload
import com.mezet.actaandroid.models.cvp.CvpPayload
import com.mezet.actaandroid.models.izdvojeni.IzdvojenoPayload
import com.mezet.actaandroid.models.jedinstvenavijesti.JedinstvenaVijest
import com.mezet.actaandroid.models.kojepratim.KojePratimPayload
import com.mezet.actaandroid.models.kursnalista.KursnaLista
import com.mezet.actaandroid.models.mojprofil.ClientProfile
import com.mezet.actaandroid.models.mostrecentnews.MostRecentNews
import com.mezet.actaandroid.models.pobjedenatenderima.TenderWinners
import com.mezet.actaandroid.models.privreda.PrivredaKategorije
import com.mezet.actaandroid.models.promo.PromoPayload
import com.mezet.actaandroid.models.promohomepage.PromoHome
import com.mezet.actaandroid.models.promokategorije.PromoKategorije
import com.mezet.actaandroid.models.publishedtenders.PublishedTenders
import com.mezet.actaandroid.models.registarsearch.RegistarPayload
import com.mezet.actaandroid.models.rezultativijesti.RezultatiVijesti
import com.mezet.actaandroid.models.testiraj_items.TestirajData
import com.mezet.actaandroid.models.ucescenatenderima.UcesceNaTenderima
import com.mezet.actaandroid.models.vijestikategorije.VijestiKategorije
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

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

    @GET("/Services/PublishedTenders")
    fun getPublishedTenders(@Query("id") id : Int,@Query("page") page : Int,
                            @Query("query") query : String, @Header("Authorization")token:String):Call<PublishedTenders>

    @GET("/Services/Winners")
    fun getWinners(@Query("id") id : Int,@Query("page") page : Int,
                            @Query("query") query : String, @Header("Authorization")token:String):Call<TenderWinners>

    @GET("/Services/EquipmentProviders")
    fun getEquipmentProviders(@Query("id") id : Int,@Query("page") page : Int,
                   @Query("query") query : String, @Header("Authorization")token:String):Call<PublishedTenders>

    @GET("/Services/Participation")
    fun getParticipation(@Query("id") id : Int,@Query("page") page : Int,
                   @Query("query") query : String, @Header("Authorization")token:String):Call<UcesceNaTenderima>

    @GET("/Services/CompanyLinks")
    fun getCompanyLinks(@Query("id") id : Int,@Query("page") page : Int,
                   @Query("query") query : String, @Header("Authorization")token:String):Call<PublishedTenders>

    @GET("/Services/ProcurementPlans")
    fun getProcurementPlans(@Query("id") id : Int,@Query("page") page : Int,
                   @Query("query") query : String, @Header("Authorization")token:String):Call<PublishedTenders>


    //PROMO

    @GET("/Services/CategoryPromoByCategoryId")
    fun getPromoCategorybyId(@Query("categoryId") categoryId : Int,@Query("limit") limit : Int):Call<PromoPayload>

    @GET("/Services/GetPromo")
    fun getPromo() : Call<PromoHome>

    @GET("/Services/getPromoCategoriesTitles")
    fun getCategories():Call<PromoKategorije>

    @POST("/Services/SearchResultNewsPromo")
    fun getnewsSearch(@Body body : Search):Call<RezultatiVijesti>

    @GET("/Services/cpvIdustries")
    fun getPrivredaCategories():Call<PrivredaKategorije>

    @GET("/Services/getNewsParentSections")
    fun getVijestiCategories():Call<VijestiKategorije>

    @GET("/Services/getArticle")
    fun getUniqeNew(@Query("articleId") articleId:Int):Call<JedinstvenaVijest>

    @GET("/Services/GetStock")
    fun getStock():Call<Berza>

    @GET("/Services/GetExchangeList")
    fun getKursnaLista():Call<KursnaLista>

    @GET("/Services/GetPaketData")
    fun getPacketData():Call<TestirajData>

    @GET("/Services/GetTeritoriesAutocomplete")
    fun getCountryAutocomplete(@Query("term") term:String,
                               @Query("country") country:String):Call<AutocompleteCountry>

    @GET("/Services/GetTeritoriesAutocomplete")
    fun getCountryAutocomplete2(@Query("term") term:String):Call<AutocompleteCountry>

    @GET("/Services/GetSourcesAutocomplete")
    fun getSourcesAutocomplete(@Query("term") term:String):Call<CvpPayload>

    @GET("/Services/GetCpvsAutocomplete")
    fun getCvpsAutocomplete(@Query("term") term:String):Call<CvpPayload>

    @POST("/Services/SearchRegisterNew")
    fun getSearchRegisterNew(@Body body : Registar):Call<RegistarPayload>

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