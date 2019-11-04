package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {
            calculateRepayment()
        }

    }

    private fun calculateRepayment() {
        //TODO get inputs and show outputs
        if(editTextCarPrice.text.isEmpty()){
            editTextCarPrice.setError(getString(R.string.error_input))
            return
        }
        val carPrice: Int = editTextCarPrice.text.toString().toInt()
        val downPayment : Int = editTextDownPayment.text.toString().toInt()
        val loan : Int = carPrice - downPayment
        val loanPeriod : Int = editTextLoanPreiod.text.toString().toInt()
        val interestRate : Float = editTextInterestRate.text.toString().toFloat() / 100
        val interest : Float = loan * interestRate * loanPeriod
        val monthlyRepayment : Float = ( loan + interest ) / loanPeriod / 12

        textViewLoan.setText(getString(R.string.loan) + "${loan}")
        textViewInterest.setText(getString(R.string.interest) + "${interest}")
        textViewMonthlyRepayment.setText(getString(R.string.monthly_repayment) + "${monthlyRepayment}")
    }

    fun reset(view: View){
        //TODO clear all input and output
        textViewLoan.setText(getString(R.string.loan) + "")
        textViewInterest.setText(getString(R.string.interest) + "")
        textViewMonthlyRepayment.setText(getString(R.string.monthly_repayment) + "")
    }
}
