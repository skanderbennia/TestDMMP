package com.example.testdmmp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        findViewById<TextView>(R.id.id_mot_de_passe_oublie).setOnClickListener{
            Toast.makeText(this,"mot de passe oublié",Toast.LENGTH_LONG).show()
        }
        findViewById<TextView>(R.id.id_enregistrer).setOnClickListener{
            Toast.makeText(this,"enregistrer",Toast.LENGTH_LONG).show()

        }
        findViewById<TextView>(R.id.btn_annluer).setOnClickListener{
            finish()

        }
        findViewById<Button>(R.id.btn_login).setOnClickListener{
           val email_input = findViewById<EditText>(R.id.id_email).text
            val intent = Intent(this,NavActivity::class.java).apply{
                putExtra("Email", email_input.toString())
            }
            startActivity(intent)
        }
    }
}