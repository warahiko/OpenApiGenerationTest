package com.example.openapigenerationtestapi.sp.api

import com.example.openapigenerationtestapi.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Call
import okhttp3.RequestBody

import com.example.openapigenerationtestapi.sp.model.InlineObject
import com.example.openapigenerationtestapi.sp.model.Item

interface ItemApi {
    /**
     * 記事の一覧を作成日時の降順で返します。
     * getAllItems の詳細です。
     * Responses:
     *  - 200: 取得成功です。
     * 
     * @param page ページ番号 (1から100まで) (optional)
     * @param perPage 1ページあたりに含まれる要素数 (1から100まで) (optional)
     * @param query 検索クエリ (optional)
     * @return [Call]<[kotlin.collections.List<Item>]>
     */
    @GET("items")
    fun getAllItems(@Query("page") page: kotlin.String? = null, @Query("per_page") perPage: kotlin.String? = null, @Query("query") query: kotlin.String? = null): Call<kotlin.collections.List<Item>>

    /**
     * 新たに記事を作成します。
     * postItem の詳細です。
     * Responses:
     *  - 201: 作成成功です。
     *  - 0: Unexpected error
     * 
     * @param inlineObject  
     * @return [Call]<[Unit]>
     */
    @POST("items")
    fun postItem(@Body inlineObject: InlineObject): Call<Unit>

}
