package com.github.gunin_igor75.bdnetworkpatterntask.app

import android.app.Application

class RoomNetworkApp: Application() {

    override fun onCreate() {
        super.onCreate()
        Repositories.init(this)
    }
}