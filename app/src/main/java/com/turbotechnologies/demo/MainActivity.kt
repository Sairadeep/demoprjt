package com.turbotechnologies.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import viewModal.dataViewModal
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {
    lateinit var dataView: dataViewModal
    lateinit var textview: TextView
    lateinit var textviewEmail: TextView
    lateinit var textView2: TextView
    lateinit var textViewEmail2: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        dataView = ViewModelProvider(this)[dataViewModal::class.java]

        dataView.userInfo.observe(
            this
        ) { userInfo ->
            textview = findViewById(R.id.textView)
            textviewEmail = findViewById(R.id.textViewEmail)
            textView2 = findViewById(R.id.textView2)
            textViewEmail2 = findViewById(R.id.textView3)

            for ((index, user) in userInfo.withIndex()) {
                val name = user["name"].toString()
                val email = user["email"].toString()

                when (index) {
                    0 -> {
                        textview.text = name
                        textviewEmail.text = email
                    }
                    2 -> {
                        textViewEmail2.text = email
                        textView2.text = name
                    }
                }

            }
        }

        dataView.data()
    }
}