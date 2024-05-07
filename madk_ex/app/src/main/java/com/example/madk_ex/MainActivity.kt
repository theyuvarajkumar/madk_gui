package com.example.madk_ex
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val txtNumber = findViewById<EditText>(R.id.txtNumber)
        val txtCalculate = findViewById<TextView>(R.id.txtcalculate)
        val btnPrime = findViewById<Button>(R.id.btnprime)
        val btnEvenOdd = findViewById<Button>(R.id.btnevenodd)
        val btnFact = findViewById<Button>(R.id.btnfact)
        btnPrime.setOnClickListener {
            val number = txtNumber.text.toString().toIntOrNull()
            if (number != null) {
                val isPrime = isPrime(number)
                txtCalculate.text = if (isPrime) "$number is prime" else "$number is not prime"
            } else {
                txtCalculate.text = "Please enter a valid number"
            }
        }
        btnEvenOdd.setOnClickListener {
            val number = txtNumber.text.toString().toIntOrNull()
            if (number != null) {
                val isEven = number % 2 == 0
                txtCalculate.text = if (isEven) "$number is even" else "$number is odd"
            } else {
                txtCalculate.text = "Please enter a valid number"
            }
        }
        btnFact.setOnClickListener {
            val number = txtNumber.text.toString().toIntOrNull()
            if (number != null) {
                val factorial = factorial(number)
                txtCalculate.text = "Factorial of $number is $factorial"
            } else {
                txtCalculate.text = "Please enter a valid number"
            }
        }
    }
    private fun isPrime(number: Int): Boolean {
        if (number <= 1) return false
        for (i in 2 until number) {
            if (number % i == 0) {
                return false
            }
        }
        return true
    }
    private fun factorial(number: Int): Int {
        var result = 1
        for (i in 1..number) {
            result *= i
        }
        return result
    }
}