package com.example.madk_simplemath

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    private lateinit var xEditText: EditText
    private lateinit var yEditText: EditText
    private lateinit var addButton: RadioButton
    private lateinit var subButton: RadioButton
    private lateinit var mulButton: RadioButton
    private lateinit var divButton: RadioButton
    private lateinit var checkButton: Button
    private lateinit var numericEvaluationButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        xEditText = findViewById(R.id.editTextText2)
        yEditText = findViewById(R.id.editTextText)
        addButton = findViewById(R.id.radioButtonAdd)
        subButton = findViewById(R.id.radioButtonSub)
        mulButton = findViewById(R.id.radioButtonMul)
        divButton = findViewById(R.id.radioButtonDiv)
        checkButton = findViewById(R.id.button)
        numericEvaluationButton = findViewById(R.id.buttonmath2)

        checkButton.setOnClickListener {
            val xValue = xEditText.text.toString().toDoubleOrNull()
            val yValue = yEditText.text.toString().toDoubleOrNull()

            if (xValue == null || yValue == null) {
                showToast("Please enter valid numbers")
                return@setOnClickListener
            }

            val result = when {
                addButton.isChecked -> xValue + yValue
                subButton.isChecked -> xValue - yValue
                mulButton.isChecked -> xValue * yValue
                divButton.isChecked -> {
                    if (yValue == 0.0) {
                        showToast("Cannot divide by zero")
                        return@setOnClickListener
                    }
                    xValue / yValue
                }
                else -> 0.0
            }

            // Format the result based on the decimal values entered by the user
            val decimalCountX = xEditText.text.toString().substringAfterLast('.', "").length
            val decimalCountY = yEditText.text.toString().substringAfterLast('.', "").length
            val decimalCountResult = maxOf(decimalCountX, decimalCountY)
            //val formattedResult = String.format("%.${decimalCountResult}f", result)

            showAlert("Result", "The result is: $result")
        }

        numericEvaluationButton.setOnClickListener {
            // Navigate back to MainActivity.kt
            finish()
        }
    }

    private fun showAlert(title: String, message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
            .setMessage(message)
            .setCancelable(true)
            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
        val alertDialog = builder.create()
        val window = alertDialog.window
        val layoutParams = window?.attributes
        layoutParams?.gravity = Gravity.TOP
        layoutParams?.y = 550
        window?.attributes = layoutParams
        alertDialog.show()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
