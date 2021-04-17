package com.example.testdmmp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    findViewById<TextView>(R.id.copyright_id).setOnClickListener{
        val intent: Intent =  Intent(this,LoginActivity::class.java)
        startActivity(intent)
    }
    }
}