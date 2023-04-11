package com.kailin.kotlin_app_arch.util.connect.converter

import com.google.gson.Gson
import com.google.gson.JsonIOException
import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonToken
import com.kailin.kotlin_app_arch.util.GsonHelper
import okhttp3.ResponseBody
import retrofit2.Converter
import java.io.IOException

class JsonResponseBodyConverter<Any>(private val adapter: TypeAdapter<Any>) :
    Converter<ResponseBody, Any> {

    private val gson: Gson = GsonHelper.gson

    @Throws(IOException::class)
    override fun convert(value: ResponseBody): Any {
        val jsonReader = gson.newJsonReader(value.charStream())
        return value.use {
            val result = adapter.read(jsonReader)
            if (jsonReader.peek() != JsonToken.END_DOCUMENT) {
                throw JsonIOException("JSON document was not fully consumed.")
            }
            result
        }
    }
}