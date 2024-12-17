package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.FlowersAdapter
import com.example.myapplication.databinding.ActivityOutputBinding

class OutputActivity : AppCompatActivity() {
    lateinit var binding: ActivityOutputBinding
    lateinit var adapter: FlowersAdapter
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityOutputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageList = arrayListOf(
            R.drawable.rose,
            R.drawable.daisy,
            R.drawable.lily,
        )

        val flowersName = arrayListOf("Rose","Daisy", "Lily")
        val flowersDesc = arrayListOf("this is rose","this is daisy","this is lily")

        val fullName : String = intent.getStringExtra("fullName").toString()
        val email : String = intent.getStringExtra("email").toString()
        val password : String = intent.getStringExtra("password").toString()
        val gender : String = intent.getStringExtra("gender").toString()
        val country: String = intent.getStringExtra("country").toString()
        val city : String = intent.getStringExtra("city").toString()

        binding.fullNameView.text = fullName
        binding.emailView.text = email
        binding.genderView.text = gender
        binding.viewCountry.text = country
        binding.cityView.text = city

        adapter = FlowersAdapter(
            this@OutputActivity, imageList,flowersName, flowersDesc
        )

        binding.viewFlowers.adapter = adapter
        binding.viewFlowers.layoutManager = LinearLayoutManager(this@OutputActivity)
//        binding.recyclerViewBirds.layoutManager = GridLayoutManager(this@DashboardActivity,2)

        setContentView(R.layout.activity_output)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.countryView)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}