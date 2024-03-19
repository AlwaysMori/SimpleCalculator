package com.nanda.calculator

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var currentNumber = ""
    private var operand1: Double = 0.0
    private var operand2: Double = 0.0
    private var currentOperator = ""
    private var isNewOperation = true

    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvResult = findViewById(R.id.tvResult)
    }

    fun onDigitClick(view: View) {
        if (isNewOperation) {
            currentNumber = ""
            isNewOperation = false
        }
        currentNumber += (view as TextView).text
        tvResult.text = currentNumber
    }

    fun onDecimalClick(view: View) {
        if (!currentNumber.contains(".")) {
            currentNumber += "."
            tvResult.text = currentNumber
        }
    }

    fun onClear(view: View) {
        currentNumber = ""
        operand1 = 0.0
        operand2 = 0.0
        currentOperator = ""
        isNewOperation = true
        tvResult.text = "0"
    }

    fun onOperatorClick(view: View) {
        if (currentNumber.isNotEmpty()) {
            operand1 = currentNumber.toDouble()
        }
        currentOperator = (view as TextView).text.toString()
        isNewOperation = true
    }

    fun onEquals(view: View) {
        if (currentNumber.isNotEmpty()) {
            operand2 = currentNumber.toDouble()
        }
        var result = when (currentOperator) {
            "+" -> operand1 + operand2
            "-" -> operand1 - operand2
            "x" -> operand1 * operand2
            "/" -> operand1 / operand2
            else -> 0.0
        }
        tvResult.text = result.toString()
        currentNumber = result.toString()
        isNewOperation = true
    }
}
