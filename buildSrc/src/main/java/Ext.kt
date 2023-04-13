object Version {

    const val gradle = "7.4.0"
    const val kotlin = "1.8.10"
    const val gson = "2.10"

    object AndroidX {
        const val core = "1.10.0"
        const val appCompat = "1.5.1"
        const val navigation = "2.5.3"
        const val lifecycle = "2.6.1"
        const val room = "2.5.1"

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

    const val gson = "com.google.code.gson:gson:${Version.gson}"
    object Kotlin {
        const val reflect = "org.jetbrains.kotlin:kotlin-reflect:${Version.kotlin}"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.kotlin}"
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.kotlin}"
    }

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
            const val uiTooling =
                "androidx.compose.ui:ui-tooling:${Version.AndroidX.Componse.ui}"
            const val uiTest =
                "androidx.compose.ui:ui-test-manifest:${Version.AndroidX.Componse.ui}"
            const val uiJunit =
                "androidx.compose.ui:ui-test-junit4:${Version.AndroidX.Componse.ui}"
            const val material3 =
                "androidx.compose.material3:material3:${Version.AndroidX.Componse.material3}"
            const val navigation =
                "androidx.navigation:navigation-compose:${Version.AndroidX.navigation}"
        }

        object Room{
            const val runtime ="androidx.room:room-runtime:${Version.AndroidX.room}"
            const val ktx ="androidx.room:room-ktx:${Version.AndroidX.room}"
            const val compiler ="androidx.room:room-compiler:${Version.AndroidX.room}"
            const val testing ="androidx.room:room-testing:${Version.AndroidX.room}"
        }
    }

    object Dagger {
        const val hilt = "com.google.dagger:hilt-android:${Version.Dagger.hilt}"
        const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:1.0.0"
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
        const val domain = "\"https://cafenomad.tw\""
        const val timeout = "${30 * 1000L}L"
    }

    object Stage {
        const val domain = "\"https://cafenomad.tw\""
        const val timeout = "${30 * 1000L}L"
    }

    object Prod {
        const val domain = "\"https://cafenomad.tw\""
        const val timeout = "${15 * 1000L}L"
    }
}