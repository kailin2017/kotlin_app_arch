package com.kailin.kotlin_app_arch.util.connect.converter

import com.google.gson.reflect.TypeToken
import com.kailin.kotlin_app_arch.util.GsonHelper
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

class JsonConverterFactory : Converter.Factory() {

    private val gson = GsonHelper.gson

    override fun responseBodyConverter(
        type: Type, annotations: Array<out Annotation>, retrofit: Retrofit
    ): Converter<ResponseBody, *> {
        val adapter = gson.getAdapter(TypeToken.get(type))
        return JsonResponseBodyConverter(adapter)
    }

    override fun requestBodyConverter(
        type: Type,
        parameterAnnotations: Array<out Annotation>,
        methodAnnotations: Array<out Annotation>,
        retrofit: Retrofit
    ): Converter<*, RequestBody> {
        val adapter = gson.getAdapter(TypeToken.get(type))
        return JsonRequestBodyConverter(adapter)
    }
}