package com.returnpal.androidapp

import android.app.Application
import com.returnpal.androidapp.services.Backend

class ReturnPals : Application() {
    override fun onCreate() {
        super.onCreate()
        Backend.initialize(applicationContext)
    }
}