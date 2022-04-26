package com.mikkyboy.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker = findViewById<View>(R.id.btnDatePicker)

        btnDatePicker.setOnClickListener { view ->
            clickDatePicker(view)
        }


    }

    fun clickDatePicker(View: View) {

        val tvSelectedDate = findViewById<View>(R.id.tvSelectedDate) as TextView
        var myAge = findViewById<View>(R.id.myAge) as TextView

        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDayOfMonth ->
                Toast.makeText(
                    this,
                    "The chosen year is $selectedYear, the month is $selectedMonth and the day is $selectedDayOfMonth",
                    Toast.LENGTH_LONG
                ).show()

                val selectedDate = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"

                tvSelectedDate.setText(selectedDate);

                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                val theDate = sdf.parse(selectedDate)

                val age = year - selectedYear

                println("MyDate")
                println("===> ${year - selectedYear}")
                println(theDate?.toString())

                if (age == 0) {
                    myAge.text = "You are $selectedMonth months old"

                } else {
                    myAge.text = "You are $age years old"
                }

            },
            year,
            month,
            day
        ).show()
    }
}