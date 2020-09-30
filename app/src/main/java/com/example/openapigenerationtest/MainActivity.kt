package com.example.openapigenerationtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.itemButton
import kotlinx.android.synthetic.main.activity_main.itemText
import kotlinx.android.synthetic.main.activity_main.userButton
import kotlinx.android.synthetic.main.activity_main.userText

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.users.observe(this, Observer { users ->
            userText.text = users.joinToString(separator = ",\n", prefix = "[\n", postfix = "\n]")
        })
        viewModel.items.observe(this, Observer { items ->
            itemText.text = items.joinToString(separator = ",\n", prefix = "[\n", postfix = "\n]")
        })

        userButton.setOnClickListener {
            viewModel.getAllUsers()
        }
        itemButton.setOnClickListener {
            viewModel.getAllItems()
        }
    }
}