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

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>>
        get() = _users

    private val _items = MutableLiveData<List<Item>>()
    val items: LiveData<List<Item>>
        get() = _items

    fun getAllUsers() {
        QiitaUserService().getAllUser(callback = object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (!response.isSuccessful) return

                _users.postValue(response.body())
            }
        })
    }

    fun getAllItems() {
        QiitaItemService().getAllItems(callback = object : Callback<List<Item>> {
            override fun onFailure(call: Call<List<Item>>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<List<Item>>, response: Response<List<Item>>) {
                if (!response.isSuccessful) return

                _items.postValue(response.body())
            }
        })
    }
}