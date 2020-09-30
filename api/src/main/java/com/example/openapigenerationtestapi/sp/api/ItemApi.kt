package com.example.openapigenerationtestapi.sp.api

import com.example.openapigenerationtestapi.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Call
import okhttp3.RequestBody
import okhttp3.ResponseBody
import okhttp3.MultipartBody

import com.example.openapigenerationtestapi.sp.model.Item

interface ItemApi {
    @GET("/api/v2/items")
    fun getAllItems(@Query("page") page: kotlin.String, @Query("per_page") perPage: kotlin.String, @Query("query") query: kotlin.String): Call<kotlin.Array<Item>>

}
