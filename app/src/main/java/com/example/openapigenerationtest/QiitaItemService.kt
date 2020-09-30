package com.example.openapigenerationtest

import com.example.openapigenerationtestapi.infrastructure.ApiClient
import com.example.openapigenerationtestapi.sp.api.ItemApi
import com.example.openapigenerationtestapi.sp.model.Item
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Callback

class QiitaItemService {

    private val itemApi: ItemApi

    init {
        val loggingInterceptor =  HttpLoggingInterceptor().apply {
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

        itemApi = ApiClient(okHttpClient = httpClient).createService(ItemApi::class.java)
    }

    fun getAllItems(page: Int, perPage: Int, query: String, callback: Callback<Array<Item>>) {
        val call = itemApi.getAllItems(page.toString(), perPage.toString(), query)
        call.enqueue(callback)
    }
}