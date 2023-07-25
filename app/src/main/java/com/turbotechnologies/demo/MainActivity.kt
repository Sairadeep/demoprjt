package com.turbotechnologies.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextClock
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import viewModal.dataViewModal

class MainActivity : AppCompatActivity() {
    lateinit var dataView: dataViewModal
    lateinit var textview: TextView
    lateinit var textviewEmail : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataView = ViewModelProvider(this)[dataViewModal::class.java]

        dataView.userNamed.observe(
            this
        ) { userNamed ->
            textview = findViewById(R.id.textView)
            textview.text = userNamed
        }

        dataView.email.observe(
            this,
        ){
                userGmail ->
            textviewEmail = findViewById(R.id.textViewEmail)
            textviewEmail.text = userGmail

        }

        dataView.data()
    }
}