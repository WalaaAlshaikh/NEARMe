package com.example.nearmeproject.views.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nearmeproject.model.images.ImageModel
import com.example.nearmeproject.model.images.Photo
import com.example.nearmeproject.model.images.Photos
import com.example.nearmeproject.repositories.ApiRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

private const val TAG = "ImageViewModel"
class ImageViewModel:ViewModel() {

    val apiRepo=ApiRepo.get()


    val imageLiveData=MutableLiveData<ImageModel>()

    fun callImage(){

        viewModelScope.launch (Dispatchers.IO){
            try {

                val response=apiRepo.getImages(26.399250,49.984360)
                if (response.isSuccessful){
                    response.body()?.run {
                        Log.d(TAG,response.body().toString())
                        imageLiveData.postValue(this)


                    }
                }else{
                    Log.d(TAG,response.message())
                }

            }catch (e:Exception){
                Log.d(TAG,e.message.toString())
                ////
            }
        }
    }
}