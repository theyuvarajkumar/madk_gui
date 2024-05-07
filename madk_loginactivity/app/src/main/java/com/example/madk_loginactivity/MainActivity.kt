package com.example.madk_loginactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
class MainActivity : AppCompatActivity() {
    lateinit var etname: EditText
    lateinit var etphone: EditText
    lateinit var btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etname = findViewById(R.id.editTextText)
        etphone = findViewById(R.id.editTextText2)
        btn = findViewById(R.id.button)
        btn.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("name", etname.text.toString())
            bundle.putString("phone", etphone.text.toString())
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }
}
