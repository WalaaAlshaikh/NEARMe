package com.example.nearmeproject.repositories

import android.content.Context
import com.example.nearmeproject.api.ImageApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.lang.Exception

private const val BASE_URL="https://www.flickr.com"
class ApiRepo {
private val retrofitService=Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

    private val apiRetrofit=retrofitService.create(ImageApi::class.java)
     suspend fun getImages(lat:Double,lon:Double)=apiRetrofit.getImage(lat,lon)

    suspend fun fetchphotodetails()=apiRetrofit.fetchSinglePicture()



    companion object{
        private var instance:ApiRepo?=null

        fun init(context: Context){
            if(instance== null )
                instance= ApiRepo()
        }
        fun get(): ApiRepo{
            return instance ?: throw Exception ("ApiServiceRepositories must be initialized ")
        }
    }



}