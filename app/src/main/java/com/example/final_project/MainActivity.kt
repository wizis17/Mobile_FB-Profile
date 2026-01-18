package com.example.final_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

// ah poy side
import android.content.Intent
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.final_project.adapter.ActivityAdapter
import com.example.final_project.api.model.Profile
import com.example.final_project.api.model.UserActivity
import com.example.final_project.api.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import androidx.lifecycle.lifecycleScope // For 'lifecycleScope'
import kotlinx.coroutines.launch           // For 'launch'
import com.example.final_project.databinding.MyActivityBinding // For your main layout binding
import com.example.final_project.api.RetrofitClient // To use your separate network file

class MainActivity : AppCompatActivity() {

    // 1. Declare Variables
    private lateinit var binding: MyActivityBinding // The "Face" manager
    private lateinit var adapter: ActivityAdapter
    private var allActivities = listOf<UserActivity>()

    // The entry point of the activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setup viewbinding
        binding = MyActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // init the Ui and load Data
        setupUI()
        loadData()
    }

    // Setup Ui prepares all interactive elements
    private fun setupUI() {
//        adapter and define what happens when an item is click
        adapter = ActivityAdapter(listOf()) { item ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("DATA", item)
            startActivity(intent)
        }
        binding.rvActivities.adapter = adapter
        binding.rvActivities.layoutManager = LinearLayoutManager(this)

        // Filters using the Binding IDs
        // attach click listeners to the filter buttons
        binding.btnYear1.setOnClickListener { filter(1) }
        binding.btnYear2.setOnClickListener { filter(2) }
        binding.btnYear3.setOnClickListener { filter(3) }
        binding.btnYear4.setOnClickListener { filter(4) }

        // view-Toggle Button
        binding.btnToggleView.setOnClickListener {
            adapter.isGridMode = !adapter.isGridMode // flip the mode
            // change the layout base on new mode
            binding.rvActivities.layoutManager = if (adapter.isGridMode)
                GridLayoutManager(this, 2) else LinearLayoutManager(this)

          //  Refresh the RecyclerView
            adapter.notifyDataSetChanged()
        }
    }

    // fetch data from API
    private fun loadData() {
// Launch a coroutine that is automatically cancelled when the activity
        lifecycleScope.launch {
            try {
                // make the network calls using Retro
                val profile = RetrofitClient.instance.getProfile()
                allActivities = RetrofitClient.instance.getActivities()

               // display profile UI using viewBinding
                binding.txtProfileName.text = "${profile.firstName} ${profile.lastName}"
                binding.txtMajor.text = "${profile.major}-${profile.generation}"
                Glide.with(this@MainActivity).load(profile.profileImage).into(binding.imgProfile)
                Glide.with(this@MainActivity).load(profile.coverImage).into(binding.imgCover)

                // Send Activities to the RecyclerView adapter to display
                adapter.updateData(allActivities)

            } catch (e: Exception) {
                Toast.makeText(this@MainActivity, "Error: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }
    // filter activities by year
    private fun filter(year: Int) {
        adapter.updateData(allActivities.filter { it.year == year })
    }
}
