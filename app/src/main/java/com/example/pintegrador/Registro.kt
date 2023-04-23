package com.example.pintegrador

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.FirebaseFirestore

class Registro : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        setup()
    }
    private fun setup(){
        val registrar = findViewById<android.widget.Button>(R.id.registrar)
        val nolote = findViewById<android.widget.EditText>(R.id.nolote)
        val noparte = findViewById<android.widget.EditText>(R.id.noparte)
        val fechaaper = findViewById<android.widget.EditText>(R.id.fechaaper)
        val inspector = findViewById<android.widget.EditText>(R.id.inspector)
        val cantidad = findViewById<android.widget.EditText>(R.id.cantidad)
        registrar.setOnClickListener {
            db.collection("Lotes").document(nolote.text.toString()).set(
                hashMapOf("Numero de parte" to noparte.text.toString(),
                    "Fecha de apertura" to fechaaper.text.toString(),
                "Inspector" to inspector.text.toString(),
                "Cantidad" to cantidad.text.toString()
                )
            )
            showmain2()
        }
    }
    private fun showmain2(){
        val intent: Intent = Intent(this,MainActivity2::class.java)
        startActivity(intent)
    }
}