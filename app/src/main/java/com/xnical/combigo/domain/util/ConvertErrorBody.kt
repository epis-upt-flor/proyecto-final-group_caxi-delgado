package com.xnical.combigo.domain.util

import android.util.Log
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.xnical.combigo.domain.model.ErrorResponse
import okhttp3.ResponseBody

// CONVIERTE EL CUERPO DE UNA RESPUESTA DE ERRORBODY EN UN OBJETO ERRORRESPONSE
// UTILIZANDO LA BIBLIOTECA MOSHI
object ConvertErrorBody {

    fun convert(errorBody: ResponseBody?): ErrorResponse? {
        return try {
            errorBody?.source()?.let {
                val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

                val moshiAdapter = moshi.adapter(ErrorResponse::class.java)
                moshiAdapter.fromJson(it)
            }
        } catch (e: Exception) {
            Log.d("ConvertErrorBody", "Error: " + e.message)
            null
        }
    }
}