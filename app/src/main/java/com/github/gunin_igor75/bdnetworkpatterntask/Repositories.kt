package com.github.gunin_igor75.bdnetworkpatterntask

import android.content.Context

object Repositories {

    lateinit var applicationContext: Context




    fun init(context: Context) {
        applicationContext = context
    }
}