package com.example.nearme.views.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nearme.model.images.ImageModel
import com.example.nearme.repositories.ApiRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

private const val TAG = "mapViewModel"
class mapViewModel:ViewModel() {

    val apiRepo= ApiRepo.get()
    val mapLiveData= MutableLiveData<ImageModel>()



    fun callImage(lat:Double, lon:Double){

        viewModelScope.launch (Dispatchers.IO){
            try {

                val response=apiRepo.getImages(lat,lon)
                if (response.isSuccessful){
                    response.body()?.run {
                        Log.d(TAG,response.body().toString())
                        mapLiveData.postValue(this)


                    }
                }else{
                    Log.d(TAG,response.message())
                }

            }catch (e: Exception){
                Log.d(TAG,e.message.toString())
                ////
            }
        }
    }
}