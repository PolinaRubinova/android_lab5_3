package com.example.android_lab5_3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android_lab5_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.downloadImageTask()
        viewModel.bitmapData.observe(this) {
            binding.imageView.setImageBitmap(it)
        }
    }
}