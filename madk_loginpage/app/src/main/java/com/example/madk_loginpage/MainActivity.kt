package com.example.madk_loginpage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editTextText = findViewById<EditText>(R.id.editTextText)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
            val enteredText = editTextText.text
            Toast.makeText(this@MainActivity,enteredText,Toast.LENGTH_LONG).show()
        }
    }
}
