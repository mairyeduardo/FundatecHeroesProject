package com.example.fundatecheroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    val test = Test(
        label1 = "Usuario",
    )


    }

  private fun executaAcao1(value1: String, value2: String){

  }

    private fun executaAcao2(value1: String, value2: String){

    }

}

data class Test (val label1: String, val label2: String? = null)