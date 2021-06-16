package com.example.testdmmp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testdmmp.models.Planet
import com.example.testdmmp.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository:Repository):ViewModel() {
val myResponse : MutableLiveData<Response<List<Planet>>> = MutableLiveData()
    fun getPlanet(){
    viewModelScope.launch {
        val response = repository.getPlanet();
        myResponse.value = response;
    }


}
}