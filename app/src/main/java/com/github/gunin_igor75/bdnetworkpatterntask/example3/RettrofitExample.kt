package com.github.gunin_igor75.bdnetworkpatterntask.example3

import android.util.Log
import okhttp3.Interceptor


fun interceptorRequestCode(tag: String): Interceptor {
    return Interceptor {chain ->
        val request = chain.request()
        val response = chain.proceed(request)
        val message = "${request.method} ${request.url}"
        val code = response.code
        Log.d(tag, "$message : status code :$code")
        response
    }
}