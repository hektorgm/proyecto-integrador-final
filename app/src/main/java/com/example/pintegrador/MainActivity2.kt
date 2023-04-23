package com.example.pintegrador

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

enum class ProviderType {
    BASIC
}

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        setup()
    }
    private fun setup() {
        val registrarlote = findViewById<android.widget.Button>(R.id.registrarlote)
        val consultar = findViewById<android.widget.Button>(R.id.consultar)
        val salir = findViewById<android.widget.Button>(R.id.salir)

        registrarlote.setOnClickListener {
            showRegistro()
        }

        consultar.setOnClickListener {
            showConsulta()
        }

        salir.setOnClickListener {
            showSalir()
        }
    }
    private fun showRegistro(){
        val intent: Intent = Intent(this,Registro::class.java)
        startActivity(intent)
    }
    private fun showConsulta(){
        val intent: Intent = Intent(this,Consulta::class.java)
        startActivity(intent)
    }
    private fun showSalir(){
        val intent: Intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}