package com.example.madk_loginactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
class MainActivity2 : AppCompatActivity() {
    lateinit var tvname : TextView
    lateinit var tvphone : TextView
    lateinit var btnback: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        tvname = findViewById(R.id.tvname)
        tvphone = findViewById(R.id.tvphone)
        btnback = findViewById(R.id.btnback)
        val bundle = intent.extras
        if (bundle != null)
        {
            tvname.text = "Name : ${bundle.getString("name")}"
            tvphone.text = "Phone : ${bundle.getString("phone")}"
        }
        btnback.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}

