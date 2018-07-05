package com.example.livedatademo.data.net.deserializer

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import java.util.*

class ListDeserializer : JsonDeserializer<List<*>> {
    override fun deserialize(json: JsonElement, type: Type, context: JsonDeserializationContext): List<*> {
        val jsonArray = json.asJsonArray
        val elementType = (type as ParameterizedType).actualTypeArguments[0]


        val result = ArrayList<Any>(jsonArray.size())

        jsonArray.forEach { jsonElement ->
            val deserializedElement = try {
                context.deserialize<Any>(jsonElement, elementType)
            } catch (e: JsonParseException) {
                null
            }

            deserializedElement?.let {
                result.add(it)
            }
        }

        return result
    }
}