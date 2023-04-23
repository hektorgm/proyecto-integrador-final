package com.example.pintegrador

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import java.security.Provider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setup()
    }
    private fun setup() {
        title="Autenticacion"
        val entrar = findViewById<android.widget.ImageButton>(R.id.entrar)
        val iniciarsesion = findViewById<android.widget.ImageButton>(R.id.iniciarsesion)
        val email = findViewById<android.widget.EditText>(R.id.email)
        val pass = findViewById<android.widget.EditText>(R.id.pass)
        val rcontra = findViewById<android.widget.ImageButton>(R.id.rcontra)

        iniciarsesion.setOnClickListener {
            if (email.text.isNotEmpty() && pass.text.isNotEmpty()) {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email.text.toString(),
                    pass.text.toString()).addOnCompleteListener {
                        if (it.isSuccessful) {
                            showMain2(it.result?.user?.email?:"", ProviderType.BASIC)
                } else {
                    showAlert()
                }
            }
        }
    }
        entrar.setOnClickListener{
            if(email.text.isNotEmpty() && pass.text.isNotEmpty()) {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(email.text.toString(),
                pass.text.toString()).addOnCompleteListener {
                    if(it.isSuccessful){
                        showMain2(it.result?.user?.email?:"",ProviderType.BASIC)
                    } else{
                        showAlert()
                    }
                }
            }
        }
        rcontra.setOnClickListener {
            vearecu()
        }
}
    private fun showAlert() {
        val builder = AlertDialog.Builder(this )
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando al usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showMain2(email: String, provider: ProviderType){
        val homeintent = Intent(this, MainActivity2::class.java).apply{
            putExtra("email", email)
            putExtra("provider", provider.name)
        }
        startActivity(homeintent)
    }

    private fun vearecu(){
        val intent: Intent = Intent(this,Recuperarcontra::class.java)
        startActivity(intent)
    }
}