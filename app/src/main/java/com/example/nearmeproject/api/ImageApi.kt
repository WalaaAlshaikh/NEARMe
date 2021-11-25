package com.example.nearmeproject.api

import com.example.nearmeproject.model.images.ImageModel
import com.example.nearmeproject.model.images.Photo
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ImageApi {
    @GET("/services/rest/?method=flickr.photos.search&api_key=9e5f12168b375780422f42def7e7c339&extras=url_m%2C+geo&format=json&nojsoncallback=1")

   suspend fun getImage(
        @Query("lat") lat:Double,
        @Query("lon")lon:Double):Response<ImageModel>


    suspend fun fetchSinglePicture(): Response<Photo>

}