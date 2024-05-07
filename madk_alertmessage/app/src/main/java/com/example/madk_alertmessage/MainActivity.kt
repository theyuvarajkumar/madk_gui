package com.example.madk_alertmessage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.annotation.SuppressLint
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    lateinit var name:EditText
    lateinit var phone:EditText
    lateinit var sub:Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        name=findViewById(R.id.nameid)
        phone=findViewById(R.id.phoneid)
        sub=findViewById(R.id.btn)
        sub.setOnClickListener{
            val username=name.text.toString().trim()
            val pno=phone.text.toString().trim()
            if(username.isEmpty()||pno.isEmpty()){
                val builder = AlertDialog.Builder(this)
                builder.setMessage("please fill details")
                builder.setTitle("Alert !")
                builder.setCancelable(false)
                builder.setNegativeButton("back") {
                    // If user click no then dialog box is canceled.
                        dialog, which -> dialog.cancel()
                }
                val alertDialog = builder.create()
                alertDialog.show()
            }
            else{
                val message="$username is logged in with $pno"
                Toast.makeText(this@MainActivity,message,Toast.LENGTH_LONG).show()
            }
        }
    }
}
