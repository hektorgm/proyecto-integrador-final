package com.example.pintegrador

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Recuperarcontra : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperarcontra)
        setup()
    }
    private fun setup(){
        val casita = findViewById<android.widget.Button>(R.id.casita)

        casita.setOnClickListener {
            val intent: Intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}