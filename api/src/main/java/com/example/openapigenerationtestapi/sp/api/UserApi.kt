package com.example.openapigenerationtestapi.sp.api

import com.example.openapigenerationtestapi.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Call
import okhttp3.RequestBody
import okhttp3.ResponseBody
import okhttp3.MultipartBody

import com.example.openapigenerationtestapi.sp.model.User

interface UserApi {
    @GET("/api/v2/users")
    fun getAllUser(@Query("page") page: kotlin.String, @Query("per_page") perPage: kotlin.String): Call<kotlin.Array<User>>

    @GET("/api/v2/users/{user_id}")
    fun getUser(@Path("user_id") userId: kotlin.String): Call<User>

}
