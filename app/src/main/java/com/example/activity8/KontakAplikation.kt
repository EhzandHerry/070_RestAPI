package com.example.activity8

import android.app.Application
import com.example.activity8.repository.AppContainer
import com.example.activity8.repository.KontakContainer

class KontakAplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = KontakContainer()
    }
}