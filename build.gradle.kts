plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").version(Version.Android.gradle).apply(false)
    id("com.android.library").version(Version.Android.gradle).apply(false)
    id("androidx.navigation.safeargs.kotlin").version(Version.AndroidX.navigation).apply(false)
    id("com.google.dagger.hilt.android").version(Version.Dagger.hilt).apply(false)
    kotlin("android").version(Version.Android.kotlin).apply(false)
}
tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
