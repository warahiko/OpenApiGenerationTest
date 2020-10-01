package com.example.openapigenerationtestapi.sp.api

import com.example.openapigenerationtestapi.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Call
import okhttp3.RequestBody

import com.example.openapigenerationtestapi.sp.model.User

interface UserApi {
    /**
     * 全てのユーザの一覧を作成日時の降順で取得します。
     * getAllUser の詳細です。
     * Responses:
     *  - 200: 取得成功です。
     *  - 0: Unexpected error
     * 
     * @param page ページ番号 (1から100まで) (optional)
     * @param perPage 1ページあたりに含まれる要素数 (1から100まで) (optional)
     * @return [Call]<[kotlin.Array<User>]>
     */
    @GET("/api/v2/users")
    fun getAllUser(@Query("page") page: kotlin.String? = null, @Query("per_page") perPage: kotlin.String? = null): Call<kotlin.Array<User>>

    /**
     * ユーザを取得します。
     * getUser の詳細です。
     * Responses:
     *  - 200: 取得成功です。
     * 
     * @param userId ユーザID 
     * @return [Call]<[User]>
     */
    @GET("/api/v2/users/{user_id}")
    fun getUser(@Path("user_id") userId: kotlin.String): Call<User>

}
