package com.example.pintegrador

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.FirebaseFirestore

class Consulta : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consulta)
        setup()
    }

    private fun setup(){
        val conse = findViewById<android.widget.Button>(R.id.conse)
        val menuses = findViewById<android.widget.Button>(R.id.menuses)
        val todoslotes = findViewById<android.widget.Button>(R.id.todoslotes)
        val consulado = findViewById<android.widget.EditText>(R.id.consulado)
        val fechadeinicio = findViewById<android.widget.EditText>(R.id.fechadeinicio)
        val partnumber = findViewById<android.widget.EditText>(R.id.partnumber)
        val Cantidades = findViewById<android.widget.EditText>(R.id.Cantidades)
        val Inspectores = findViewById<android.widget.EditText>(R.id.Inspectores)

        conse.setOnClickListener {
            db.collection("Lotes").document(consulado.text.toString()).get().addOnSuccessListener {
                fechadeinicio.setText(it.get("Fecha de apertura")as String?)
                partnumber.setText(it.get("Numero de parte")as String?)
                Cantidades.setText(it.get("Cantidad")as String?)
                Inspectores.setText(it.get("Inspector")as String?)
            }
        }
        menuses.setOnClickListener {
            regresamenu()
        }
        todoslotes.setOnClickListener {
            db.collection("Lotes").document(consulado.text.toString()).delete()
        }
    }
    private fun regresamenu(){
        val intent: Intent = Intent(this,MainActivity2::class.java)
        startActivity(intent)
    }


}
