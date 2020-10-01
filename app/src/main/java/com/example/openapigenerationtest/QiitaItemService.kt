package com.example.openapigenerationtest

import com.example.openapigenerationtestapi.infrastructure.ApiClient
import com.example.openapigenerationtestapi.sp.api.ItemApi
import com.example.openapigenerationtestapi.sp.model.InlineObject
import com.example.openapigenerationtestapi.sp.model.Item
import com.example.openapigenerationtestapi.sp.model.Tagging
import retrofit2.Callback

class QiitaItemService {

    private val itemApi: ItemApi = ApiClient(authName = "Bearer", bearerToken = "05c2a2329bc54f8be64fc43a5640a4e785725d5c")
        .setLogger {
            println(it)
        }
        .createService(ItemApi::class.java)

    fun getAllItems(callback: Callback<List<Item>>, page: Int? = null, perPage: Int? = null, query: String? = null) {
        val call = itemApi.getAllItems(page?.toString(), perPage?.toString(), query)
        call.enqueue(callback)
    }

    fun postItem(callback: Callback<Unit>) {
        val requestBody = InlineObject(
            body = "# Example",
            coediting = false,
            groupUrlName = null,
            private = true,
            tags = listOf(
                Tagging(
                    name = "Ruby",
                    versions = listOf("0.0.1")
                )
            ),
            title = "Example title",
            tweet = false
        )
        val call = itemApi.postItem(requestBody)
        call.enqueue(callback)
    }
}