package com.github.gunin_igor75.bdnetworkpatterntask.app

import android.content.Context
import com.github.gunin_igor75.bdnetworkpatterntask.example1_2.data.local.db.FlowerShopDatabase

object Repositories {

    lateinit var applicationContext: Context

    val database: FlowerShopDatabase by lazy {
        FlowerShopDatabase.init(applicationContext)
    }

    fun init(context: Context) {
        applicationContext = context
    }
}