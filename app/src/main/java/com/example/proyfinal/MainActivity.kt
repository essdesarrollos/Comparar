package com.example.proyfinal.view


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import com.example.proyfinal.databinding.ActivityMainBinding
import com.example.proyfinal.R


class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.comparo.observe(this)
        {
            fResultado(it.bResultado)
        }

        binding.boton.setOnClickListener{

            val txt1: String = binding.txt1.text.toString()
            val txt2: String = binding.txt2.text.toString()
            mainViewModel.fComparar(txt1, txt2)
        }
    }

    private fun fResultado(bResultado: Boolean) {
        val txt: String

        if (bResultado)
        {
            txt = getString(R.string.iguales)
        }
        else
        {
           txt = getString(R.string.distintos)
          }
        binding.resultado.text = txt
        }

}

