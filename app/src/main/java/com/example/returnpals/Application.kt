package com.example.returnpals

import android.app.Application
import com.example.returnpals.services.Backend

class ReturnPals : Application() {
    override fun onCreate() {
        super.onCreate()
        Backend.initialize(applicationContext)
    }
}