package com.kailin.kotlin_app_arch.util.connect

import android.annotation.SuppressLint
import com.kailin.kotlin_app_arch.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.security.SecureRandom
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLContext
import javax.net.ssl.X509TrustManager

object OkHttpHelper {

    fun createOkHttp(vararg interceptor: Interceptor): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .followRedirects(false)
            .connectTimeout(BuildConfig.TIMEOUT, TimeUnit.SECONDS)
        for (i in interceptor) {
            builder.addInterceptor(i)
        }
        if (BuildConfig.DEBUG) {
            val x509TrustManager =
                @SuppressLint("CustomX509TrustManager")
                object : X509TrustManager {
                    @SuppressLint("TrustAllX509TrustManager")
                    override fun checkClientTrusted(p0: Array<out X509Certificate>?, p1: String?) {
                    }

                    @SuppressLint("TrustAllX509TrustManager")
                    override fun checkServerTrusted(p0: Array<out X509Certificate>?, p1: String?) {
                    }

                    override fun getAcceptedIssuers(): Array<X509Certificate> = arrayOf()
                }
            val sslContext = SSLContext.getInstance("TLS")
            sslContext.init(null, arrayOf(x509TrustManager), SecureRandom())
            builder.sslSocketFactory(sslContext.socketFactory, x509TrustManager)
            builder.hostnameVerifier { _, _ -> true }
            builder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))
        }
        return builder.build()
    }
}