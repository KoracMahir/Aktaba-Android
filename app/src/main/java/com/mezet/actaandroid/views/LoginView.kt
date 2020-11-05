package com.mezet.actaandroid.views

interface LoginView {
    fun onLoginSuccess(token : String)
    fun onLoginFailiure(message : String)
}