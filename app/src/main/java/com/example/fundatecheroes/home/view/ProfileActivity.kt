package com.example.fundatecheroes.home.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fundatecheroes.R

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSupportActionBar()?.hide()
        setContentView(R.layout.activity_profile)
    }
}