package com.example.nearme.views.main

import android.location.Location
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nearme.model.images.ImageModel
import com.example.nearme.model.images.Photo
import com.example.nearme.repositories.ApiRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

private const val TAG = "ImageViewModel"
class ImageViewModel:ViewModel() {


    val apiRepo=ApiRepo.get()
    val imageLiveData=MutableLiveData<ImageModel>()
    val imageErrorLiveData=MutableLiveData<String>()

    //****************************************************//
    val oneimagelivedata=MutableLiveData<Photo>()
    val oneImageErrorLiveData=MutableLiveData<String>()
    //*******************************************************//

    val mapLiveData=MutableLiveData<ImageModel>()
    val mapErrorLiveData=MutableLiveData<String>()

    //**************************************//

    var long:Double=0.0
    var lat:Double=0.0


    fun callImage(lat:Double, lon:Double){

        viewModelScope.launch (Dispatchers.IO){
            try {

                val response=apiRepo.getImages(lat,lon)
                if (response.isSuccessful){
                    response.body()?.run {
                        Log.d(TAG,response.body().toString())
                        imageLiveData.postValue(this)


                    }
                }else{
                    Log.d(TAG,response.message())
                    imageErrorLiveData.postValue(response.message())
                }

            }catch (e:Exception){
                Log.d(TAG,e.message.toString())
                imageErrorLiveData.postValue(e.message.toString())

            }
        }
    }

    fun mapcall(lat:Double, lon:Double){
        Log.d(TAG,"view model: lat $lat, long $long")

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
                    mapErrorLiveData.postValue(response.message())
                }

            }catch (e:Exception){
                Log.d(TAG,e.message.toString())
                mapErrorLiveData.postValue(e.message)
            }
        }
    }

    fun fetchphotodetails()
    {
//        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response=apiRepo.fetchphotodetails()
                oneimagelivedata.postValue(response)
//                if (response.isSuccessful)
//                {
//                    response.body()?.run {
//
//                        Log.d("forfetching",response.body().toString())
//                    }
//                }
//                else
//                {
//                    Log.d(TAG,response.message())
//                    oneImageErrorLiveData.postValue(response.message())
//                }

            }
            catch (e:Exception)
            {
                Log.d(TAG,e.message.toString())
                oneImageErrorLiveData.postValue(e.message)
            }


//        }
    }




}