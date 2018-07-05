package com.example.livedatademo.data.net

import com.example.livedatademo.data.net.deserializer.BooleanDeserializer
import com.example.livedatademo.data.net.deserializer.ListDeserializer
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.lang.reflect.Type

class GsonFactory {

    fun create(list: List<Pair<Type, Any>> = emptyList(), skipDefaults: Boolean = false): Gson {
        val gsonBuilder = GsonBuilder()

        if (!skipDefaults) {
            gsonBuilder.registerTypeAdapter(Boolean::class.java, BooleanDeserializer())
            gsonBuilder.registerTypeAdapter(List::class.java, ListDeserializer())
        }

        list.forEach { (first, second) -> gsonBuilder.registerTypeAdapter(first, second) }

        return gsonBuilder.create()
    }
}