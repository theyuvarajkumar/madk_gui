package com.example.madk_simplemath

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextNumber = findViewById<EditText>(R.id.editTextText)
        val radioButtonEvenOdd = findViewById<RadioButton>(R.id.radioButtonEvenOdd)
        val radioButtonPrime = findViewById<RadioButton>(R.id.radioButtonPrime)
        val radioButtonFact = findViewById<RadioButton>(R.id.radioButtonFact)
        val checkButton = findViewById<Button>(R.id.button)
        val arithmeticButton = findViewById<Button>(R.id.buttonmath)

        checkButton.setOnClickListener {
            val userInput = editTextNumber.text.toString().toIntOrNull()

            if (userInput != null) {
                val isEven = userInput % 2 == 0
                val isPrime = isPrime(userInput)
                val resultText = when {
                    radioButtonEvenOdd.isChecked -> "Number is ${if (isEven) "even" else "odd"}"
                    radioButtonPrime.isChecked -> "Number is ${if (isPrime) "prime" else "not prime"}"
                    radioButtonFact.isChecked -> "Factorial of $userInput is ${factorial(userInput)}"
                    else -> "Please select an option"
                }
                showResult(resultText)
            } else {
                Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_SHORT).show()
            }
        }

        arithmeticButton.setOnClickListener {
            // Navigate to MainActivity2
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }

    private fun isPrime(number: Int): Boolean {
        if (number <= 1) return false
        if (number <= 3) return true
        if (number % 2 == 0 || number % 3 == 0) return false
        var i = 5
        while (i * i <= number) {
            if (number % i == 0 || number % (i + 2) == 0) return false
            i += 6
        }
        return true
    }

    private fun factorial(number: Int): Int {
        var result = 1
        for (i in 2..number) {
            result *= i
        }
        return result
    }

    private fun showResult(result: String) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(result)
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
}
