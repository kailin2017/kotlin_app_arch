package tw.idv.kailin.kotlin.cafe

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class KailinApp : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}