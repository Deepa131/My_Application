package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SpinnerActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var spinner: Spinner
    lateinit var textView: TextView
    lateinit var autoCompleteTextView: AutoCompleteTextView
    val countries= arrayOf("Nepal","India","China","Japan")
    val cities= arrayOf("Kathmandu","Bhaktapur","Lalitpur","Kritipur","Kanchanpur")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_spinner)
        spinner=findViewById(R.id.spinnerCountry)
        textView=findViewById(R.id.displayCountry)
        autoCompleteTextView=findViewById(R.id.autoCompleteTextView)

        var autoAdapter=ArrayAdapter(
            this@SpinnerActivity,
            android.R.layout.simple_spinner_item, cities
        )
        autoCompleteTextView.setAdapter(autoAdapter)
        autoCompleteTextView.threshold=2  //kati letter lekhepaxi recommendation dekhaune ko lagi threshold use garne

        val adapter=ArrayAdapter(
            this@SpinnerActivity,
            android.R.layout.simple_spinner_item, countries
        )
        adapter.setDropDownViewResource(
            android.R.layout.simple_dropdown_item_1line
        )
        spinner.adapter=adapter

        spinner.onItemSelectedListener=this
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Email)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if (parent!=null){
            textView.text=parent.getItemAtPosition(position).toString()
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}