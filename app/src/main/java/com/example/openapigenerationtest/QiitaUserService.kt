package com.example.openapigenerationtest

import com.example.openapigenerationtestapi.infrastructure.ApiClient
import com.example.openapigenerationtestapi.sp.api.UserApi
import com.example.openapigenerationtestapi.sp.model.User
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Callback

class QiitaUserService {

    private val userApi: UserApi

    init {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
        val httpClient: OkHttpClient = OkHttpClient.Builder().apply {
            addInterceptor(loggingInterceptor)
            addInterceptor(Interceptor { chain ->
                chain.proceed(
                    chain.request()
                        .newBuilder()
                        .header("Content-Type", "application/json")
                        .header("Authorization", "Bearer 46f9e2655f4f0afb5ee0d721acb03693171aed26")
                        .build()
                )
            })
        }.build()

        userApi = ApiClient(okHttpClient = httpClient).createService(UserApi::class.java)
    }

    fun getAllUser(callback: Callback<Array<User>>, page: Int? = null, perPage: Int? = null) {
        val call = userApi.getAllUser(page?.toString(), perPage?.toString())
        call.enqueue(callback)
    }

    fun getUser(userId: String, callback: Callback<User>) {
        val call = userApi.getUser(userId)
        call.enqueue(callback)
    }
}