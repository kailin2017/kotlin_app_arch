package com.kailin.kotlin_app_arch

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class KailinApp : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}