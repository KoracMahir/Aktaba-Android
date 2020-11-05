package com.mezet.actaandroid.presenters

import com.mezet.actaandroid.fragments.main.login.LoginFragment
import com.mezet.actaandroid.fragments.sections.NewsBlueBlackFragment
import com.mezet.actaandroid.models.LoginResponse
import com.mezet.actaandroid.models.mostrecentnews.MostRecentNews
import com.mezet.actaandroid.services.RetrofitServices
import com.mezet.actaandroid.views.InvesticijeView
import com.mezet.actaandroid.views.LoginView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter(context: LoginFragment) {
    val loginView = context as LoginView

    fun goLogin(uname:String,password:String) {
        RetrofitServices.create()
            .Login(uname,password)
            .enqueue(object : Callback<LoginResponse> {
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if(response.body()?.token !=null) {
                        loginView.onLoginSuccess(response.body()?.token.toString())
                    }else{
                        loginView.onLoginFailiure("Korisničko ime ili korisnička šifra su netačni")
                    }
                }

            })
    }
}