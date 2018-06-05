package com.example.livedatademo.data.user.net

import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.Type

class CallAdapterFactory : CallAdapter.Factory() {


    override fun get(type: Type, annotations: Array<out Annotation>, retrofit: Retrofit): CallAdapter<*, *> {
        return object : CallAdapter<Any, Any> {
            override fun responseType(): Type {
                return type
            }

            override fun adapt(call: Call<Any>): Any? {
                return ResponseDeserializer.deserializer(call.execute())
            }
        }
    }
}