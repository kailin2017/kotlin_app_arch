package tw.idv.kailin.kotlin.cafe.util

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.lang.reflect.Type

object GsonHelper {

    val gson: Gson = GsonBuilder().serializeNulls().create()

    fun <T> fromJson(json: String, type: Type): T = gson.fromJson(json, type)

    fun <T> toJsonString(t: T): String {
        return gson.toJson(t)
    }
}