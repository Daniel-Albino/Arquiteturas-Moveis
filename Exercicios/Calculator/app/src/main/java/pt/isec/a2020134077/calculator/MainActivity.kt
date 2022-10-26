package pt.isec.a2020134077.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import pt.isec.a2020134077.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private lateinit var textViewCount : TextView
    private var strTextViewCount = "0.0"
        set(value) {
            field = value
            textViewCount.text = value
        }
    private lateinit var textViewResult : TextView
    private var strTextViewResult = "0.0"
        set(value) {
            field = value
            textViewResult.text = value
        }
    private var newNumber = true
    val currentNumber: Double
        get() = strTextViewResult.toDoubleOrNull() ?: 0.0

    var op = 0
        set(value) {
            field = value
        }
    var firstNumber = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        textViewResult = binding.textViewResult
        binding.btn0.setOnClickListener {digt(binding.btn0)}
        binding.btn1.setOnClickListener {digt(binding.btn1)}
        binding.btn2.setOnClickListener {digt(binding.btn2)}
        binding.btn3.setOnClickListener {digt(binding.btn3)}
        binding.btn4.setOnClickListener {digt(binding.btn4)}
        binding.btn5.setOnClickListener {digt(binding.btn5)}
        binding.btn6.setOnClickListener {digt(binding.btn6)}
        binding.btn7.setOnClickListener {digt(binding.btn7)}
        binding.btn8.setOnClickListener {digt(binding.btn8)}
        binding.btn9.setOnClickListener {digt(binding.btn9)}
        binding.btnPoint.setOnClickListener {point(binding.btnPoint)}

        binding.btnC.setOnClickListener {C(binding.btnC)}
        binding.btnDelete.setOnClickListener {}
        binding.btnDiv.setOnClickListener {oper(binding.btnDiv)}
        binding.btnPlus.setOnClickListener {oper(binding.btnPlus)}
        binding.btnMinus.setOnClickListener {oper(binding.btnMinus)}
        binding.btnMul.setOnClickListener {oper(binding.btnMul)}
        binding.btnPer.setOnClickListener {per(binding.btnPer)}
        binding.btnMinusPlus.setOnClickListener {plusMinus(binding.btnMinusPlus)}
        binding.btnEqual.setOnClickListener {calc(binding.btnEqual)}
    }

    fun digt(view: View){
        val btn = view as Button
        if(newNumber) {
            strTextViewResult = btn.text.toString()
            newNumber = false
        }
        else
            strTextViewResult += btn.text.toString()
    }

    fun point(view: View){
        val btn = view as Button
        if(newNumber){
            strTextViewResult = "0."
            newNumber = false
        }else
            strTextViewResult += btn.text.toString()
    }

    fun C(view: View){
        strTextViewResult = ""
        //strTextViewCount = ""
        newNumber = true
    }

    fun plusMinus(view: View){
        if(strTextViewCount[0] == '-'){
            strTextViewResult = strTextViewResult.substring(1)
        }else {
            strTextViewResult = "-$strTextViewResult"
        }
    }

    fun per(view: View){
        strTextViewCount = ""+currentNumber / 100.0
        newNumber = true
    }

    fun oper(view: View){
        if(op != 0 && !newNumber){
            calc(view)
        }
        firstNumber = currentNumber
        newNumber = true
        op = view.id
    }

    fun calc(view: View){
        var result = 0.0

        when(op){
            R.id.btnPlus -> result = firstNumber + currentNumber
            R.id.btnMinus -> result = firstNumber - currentNumber
            R.id.btnMul -> result = firstNumber * currentNumber
            R.id.btnDiv -> result = if(currentNumber != 0.0) firstNumber/currentNumber else 0.0
            else -> return
        }
        newNumber = true
        op = 0
        firstNumber = result
        strTextViewResult = "$result"
    }



}