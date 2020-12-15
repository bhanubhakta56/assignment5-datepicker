package com.example.myapplication

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var et1:EditText
    private lateinit var et2:EditText
    private lateinit var tv1:TextView
    private lateinit var tv2:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        et1 = findViewById(R.id.et1)
        et2 = findViewById(R.id.et2)
        tv1 = findViewById(R.id.tv1)
        tv2 = findViewById(R.id.tv2)


        et1.setOnClickListener{
            val flag:Boolean=true
            loadCalendar(flag)
        }
        et2.setOnClickListener {
            val flag:Boolean=false
            loadCalendar(flag)
        }
    }
    fun loadCalendar(flag:Boolean){
        val cal = Calendar.getInstance()
        val y1 = cal.get(Calendar.YEAR)
        val m1 = cal.get(Calendar.MONTH)
        val d1 = cal.get(Calendar.DAY_OF_MONTH)
        val calender = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                if(flag){
                    et1.setText("$year/${month+1}/$dayOfMonth")
                    val workedYear = y1-year
                    val workedMonth = m1-month
                    tv1.setText("$workedYear.$workedMonth year")
                }
                else{
                    et2.setText("$year/${month+1}/$dayOfMonth")
                    val ageYear = y1-year
                    val ageMonth = m1-month
                    tv2.setText("$ageYear.$ageMonth year")
                }
            },
            y1,
            m1,
            d1
        )
        calender.show()
    }
}