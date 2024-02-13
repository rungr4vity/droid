package com.example.weatherapp

import android.Manifest
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var viewmodel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val _txt =  binding.txt
        val check = ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)


        Log.d("Permission: ",check.toString())

        viewmodel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewmodel.currentNumber.observe(this, Observer {
            _txt.text = it.toString()
        })


        incrementText()
    }


    private fun incrementText(){
        val boton = findViewById<Button>(R.id.btn_button)


        boton.setOnClickListener {
                viewmodel.currentNumber.value = ++ viewmodel.number
        }
    }
}