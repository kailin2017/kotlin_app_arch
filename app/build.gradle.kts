plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("androidx.navigation.safeargs.kotlin")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.kailin.kotlin_app_arch"
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        applicationId = "com.kailin.kotlin_app_arch"
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
//    signingConfigs {
//        val properties = gradleLocalProperties(rootDir)
//        getByName("debug") {
//            storeFile = file(properties.getProperty("signingConfigs.debug.path"))
//            storePassword = properties.getProperty("signingConfigs.debug.storePassword")
//            keyAlias = properties.getProperty("signingConfigs.debug.keyAlias")
//            keyPassword = properties.getProperty("signingConfigs.debug.keyPassword")
//        }
//        create("release") {
//            storeFile = file(properties.getProperty("signingConfigs.release.path"))
//            storePassword = properties.getProperty("signingConfigs.release.storePassword")
//            keyAlias = properties.getProperty("signingConfigs.release.keyAlias")
//            keyPassword = properties.getProperty("signingConfigs.release.keyPassword")
//        }
//    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
//            signingConfig = signingConfigs.getByName("release")
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")

            buildConfigField("String", "DOMAIN", BuildConfigField.Prod.domain)
            buildConfigField("Long", "TIMEOUT", BuildConfigField.Prod.timeout)
        }
        getByName("debug") {
            applicationIdSuffix = ".debug"
//            signingConfig = signingConfigs.getByName("debug")

            buildConfigField("String", "DOMAIN", BuildConfigField.Develop.domain)
            buildConfigField("Long", "TIMEOUT", BuildConfigField.Develop.timeout)
        }
        create("stage") {
            applicationIdSuffix = ".stage"
//            signingConfig = signingConfigs.getByName("debug")

            buildConfigField("String", "DOMAIN", BuildConfigField.Stage.domain)
            buildConfigField("Long", "TIMEOUT", BuildConfigField.Stage.timeout)
        }
    }
//    applicationVariants.all {
//        resValue("string", "provideAuthorities", "${applicationId}.fileprovider")
//    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
            excludes.add("/META-INF/gradle/incremental.annotation.processors")
        }
    }
}

dependencies {
    implementation(Depends.gson)
    implementation(Depends.AndroidX.core)
    implementation(Depends.AndroidX.appCompat)
    implementation(Depends.AndroidX.lifecycleRuntime)
    implementation(Depends.AndroidX.lifecycleViewModel)
    implementation(Depends.AndroidX.Componse.activity)
    implementation(Depends.AndroidX.Componse.ui)
    implementation(Depends.AndroidX.Componse.uiPreview)
    implementation(Depends.AndroidX.Componse.material3)
    implementation(Depends.AndroidX.Componse.navigation)
    implementation(Depends.AndroidX.Room.runtime)
    implementation(Depends.AndroidX.Room.ktx)
    kapt(Depends.AndroidX.Room.compiler)
    testImplementation(Depends.AndroidX.Room.testing)
    implementation(Depends.Dagger.hilt)
    kapt(Depends.Dagger.hiltCompiler)
    implementation(Depends.Dagger.hiltNavigationCompose)
    implementation(Depends.Kotlin.reflect)
    implementation(Depends.Squareup.okHttp)
    implementation(Depends.Squareup.okHttpLogger)
    implementation(Depends.Squareup.retrofit)
    debugImplementation(Depends.AndroidX.Componse.uiTest)
    debugImplementation(Depends.AndroidX.Componse.uiTooling)
    debugImplementation(Depends.Squareup.leakCanary)
    androidTestImplementation(Depends.AndroidX.Componse.uiJunit)

}

kapt {
    correctErrorTypes = true
}