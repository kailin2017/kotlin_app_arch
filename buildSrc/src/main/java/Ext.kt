object Version {

    object Android{
        const val gradle = "7.4.0"
        const val kotlin = "1.8.10"
    }

    object AndroidX {
        const val core = "1.10.0"
        const val appCompat = "1.5.1"
        const val navigation = "2.5.3"
        const val lifecycle = "2.6.1"

        object Componse {
            const val activity = "1.7.0"
            const val ui = "1.4.1"
            const val material3 = "1.1.0-beta02"
        }
    }

    object Dagger {
        const val hilt = "2.44"
    }

    object Squareup {
        const val okHttp = "4.10.0"
        const val retrofit = "2.9.0"
        const val leakCanary = "2.10"
    }
}

object Depends {
    object AndroidX {
        const val core = "androidx.core:core-ktx:${Version.AndroidX.core}"
        const val appCompat = "androidx.appcompat:appcompat:${Version.AndroidX.appCompat}"
        const val lifecycleRuntime =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Version.AndroidX.lifecycle}"
        const val lifecycleViewModel =
            "androidx.lifecycle:lifecycle-viewmodel-compose:${Version.AndroidX.lifecycle}"

        object Componse {
            const val activity =
                "androidx.activity:activity-compose:${Version.AndroidX.Componse.activity}"
            const val ui = "androidx.compose.ui:ui:${Version.AndroidX.Componse.ui}"
            const val uiPreview =
                "androidx.compose.ui:ui-tooling-preview:${Version.AndroidX.Componse.ui}"
            const val material3 =
                "androidx.compose.material3:material3:${Version.AndroidX.Componse.material3}"
            const val navigation =
                "androidx.navigation:navigation-compose:${Version.AndroidX.navigation}"
        }
    }

    object Dagger {
        const val hilt = "com.google.dagger:hilt-android:${Version.Dagger.hilt}"
        const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Version.Dagger.hilt}"
    }

    object Squareup {
        const val okHttp = "com.squareup.okhttp3:okhttp:${Version.Squareup.okHttp}"
        const val okHttpLogger =
            "com.squareup.okhttp3:logging-interceptor:${Version.Squareup.okHttp}"
        const val retrofit = "com.squareup.retrofit2:retrofit:${Version.Squareup.retrofit}"
        const val leakCanary =
            "com.squareup.leakcanary:leakcanary-android:${Version.Squareup.leakCanary}"
    }
}


object AndroidConfig {
    const val compileSdk = 33
    const val targetSdk = compileSdk
    const val minSdk = 26
    const val versionCode = 1
    const val versionName = "1.0"
}

object BuildConfigField {

    object Develop {
        const val domain = "\"https://api.binance.com/\""
        const val timeout = "${30 * 1000L}L"
    }

    object Stage {
        const val domain = "\"https://api1.binance.com/\""
        const val timeout = "${30 * 1000L}L"
    }

    object Prod {
        const val domain = "\"https://api2.binance.com/\""
        const val timeout = "${15 * 1000L}L"
    }
}