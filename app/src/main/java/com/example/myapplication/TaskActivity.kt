package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.FlowersAdapter
import com.example.myapplication.adapter.FruitsAdapter
import com.example.myapplication.databinding.ActivityTaskBinding

class TaskActivity : AppCompatActivity() {
    lateinit var binding: ActivityTaskBinding
    val countries = arrayOf("Nepal","India","China","Japan")
    val cities = arrayOf("Kathmandu","Bhaktapur","Lalitpur","Kritipur","Kanchanpur")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up Spinner with country list
        val countryAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.countryDropdown.adapter = countryAdapter

        // Set up AutoCompleteTextView with city suggestions
        val cityAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, cities)
        binding.autocompleteCity.setAdapter(cityAdapter)

        binding.submit.setOnClickListener {
            val fullName: String = binding.textfullName.text.toString()
            val email: String = binding.edittextEmail.text.toString()
            val password: String = binding.edittextPassword.toString()
            val isMale = binding.male.isChecked
            val isFemale = binding.female.isChecked
            val country =  binding.countryDropdown.selectedItem?.toString() ?:""
            val city = binding.autocompleteCity.text.toString()
            val agreedTerms = binding.agreeTerms.isChecked

            val gender = when {
                isMale -> "Male"
                isFemale -> "Female"
                else -> ""
            }

            if (binding.textfullName.isEmpty()) {
                binding.textfullName.error = "name can't be empty"
            } else if (binding.edittextEmail.isEmpty()) {
                binding.edittextEmail.error = "email can't be empty"
            } else if (binding.edittextPassword.isEmpty()) {
                binding.textfullName.error = "password can't be empty"
            }else if(!isMale&& !isFemale) {
                Toast.makeText(this, "please select a gender", Toast.LENGTH_SHORT).show()
            }else if(!agreedTerms){
                Toast.makeText(this, "You must agree to the terms and conditions", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this@TaskActivity, OutputActivity::class.java)
                intent.putExtra("fullName", fullName)
                intent.putExtra("email", email)
                intent.putExtra("gender", gender)
                intent.putExtra("country", country)
                intent.putExtra("city", city)

                startActivity(intent)
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Email)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}


