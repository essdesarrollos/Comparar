package com.example.proyfinal.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyfinal.model.Comparo
import kotlinx.coroutines.launch

class MainViewModel: ViewModel()
{
    private var _comparo = MutableLiveData<Comparo>()
    val comparo: LiveData<Comparo> get() = _comparo

    fun fComparar(txt1: String, txt2: String){
        val bResultado = txt1 == txt2
        updateComparo(txt1, txt2, bResultado)
        }

    private fun updateComparo(txt1: String, txt2: String, bResultado: Boolean)
        {
        viewModelScope.launch {
            _comparo.value = Comparo(txt1, txt2, bResultado)
            }
        }
}