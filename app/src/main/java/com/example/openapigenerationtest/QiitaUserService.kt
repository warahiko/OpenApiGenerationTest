package com.example.openapigenerationtest

import com.example.openapigenerationtestapi.infrastructure.ApiClient
import com.example.openapigenerationtestapi.sp.api.ItemApi
import com.example.openapigenerationtestapi.sp.api.UserApi
import com.example.openapigenerationtestapi.sp.model.User
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Callback

class QiitaUserService {

    private val userApi: UserApi = ApiClient(authName = "Bearer", bearerToken = "05c2a2329bc54f8be64fc43a5640a4e785725d5c")
        .setLogger {
            println(it)
        }
        .createService(UserApi::class.java)

    fun getAllUser(callback: Callback<List<User>>, page: Int? = null, perPage: Int? = null) {
        val call = userApi.getAllUser(page?.toString(), perPage?.toString())
        call.enqueue(callback)
    }

    fun getUser(userId: String, callback: Callback<User>) {
        val call = userApi.getUser(userId)
        call.enqueue(callback)
    }
}