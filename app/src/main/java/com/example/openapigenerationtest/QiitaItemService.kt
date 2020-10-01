package com.example.openapigenerationtest

import com.example.openapigenerationtestapi.infrastructure.ApiClient
import com.example.openapigenerationtestapi.sp.api.ItemApi
import com.example.openapigenerationtestapi.sp.model.Item
import retrofit2.Callback

class QiitaItemService {

    private val itemApi: ItemApi = ApiClient()
        .setLogger {
            println(it)
        }
        .createService(ItemApi::class.java)

    fun getAllItems(callback: Callback<List<Item>>, page: Int? = null, perPage: Int? = null, query: String? = null) {
        val call = itemApi.getAllItems(page?.toString(), perPage?.toString(), query)
        call.enqueue(callback)
    }
}