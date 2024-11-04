package com.example.recyclerviewpict

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerviewpict.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val pictureList = generatePictures()
        val adapterPicture = PictureAdapter(pictureList)

        with(binding) {
            rvPicture.apply {
                adapter = adapterPicture
                layoutManager = GridLayoutManager(this@MainActivity, 3)
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun generatePictures() : List<Picture> {
        return listOf(
            Picture(R.drawable.baseline_motor_wheeler_24, "Motor"),
            Picture(R.drawable.baseline_directions_car_24, "Mobil"),
            Picture(R.drawable.baseline_truck_shipping_24, "Truk"),
            Picture(R.drawable.baseline_airplanemode_active_24, "Pesawat"),
            Picture(R.drawable.baseline_train_24, "Kereta"),
            Picture(R.drawable.baseline_directions_bus_24, "Bis")
        )
    }
}