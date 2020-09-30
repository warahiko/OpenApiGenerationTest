package com.example.openapigenerationtest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.openapigenerationtestapi.sp.model.Item
import com.example.openapigenerationtestapi.sp.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val _users = MutableLiveData<Array<User>>()
    val users: LiveData<Array<User>>
        get() = _users

    private val _items = MutableLiveData<Array<Item>>()
    val items: LiveData<Array<Item>>
        get() = _items

    fun getAllUsers() {
        QiitaUserService().getAllUser(1, 20, object : Callback<Array<User>> {
            override fun onFailure(call: Call<Array<User>>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<Array<User>>, response: Response<Array<User>>) {
                if (!response.isSuccessful) return

                _users.postValue(response.body())
            }
        })
    }

    fun getAllItems() {
        QiitaItemService().getAllItems(1, 20, "", object : Callback<Array<Item>> {
            override fun onFailure(call: Call<Array<Item>>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<Array<Item>>, response: Response<Array<Item>>) {
                if (!response.isSuccessful) return

                _items.postValue(response.body())
            }
        })
    }
}