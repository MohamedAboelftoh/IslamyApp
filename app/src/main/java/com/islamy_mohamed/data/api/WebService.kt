package com.islamy_mohamed.data.api

import com.islamy_mohamed.data.model.RadioResponse
import retrofit2.Call
import retrofit2.http.GET

interface WebService {
    @GET("radios")
    suspend fun getRadio() : RadioResponse
}