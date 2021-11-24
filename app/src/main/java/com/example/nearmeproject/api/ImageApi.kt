package com.example.nearmeproject.api

import com.example.nearmeproject.model.images.ImagesModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ImageApi {
    @GET("services/rest/?method=flickr.photos.search&api_key=9e5f12168b375780422f42def7e7c339&lat=26.420683&lon=50.088795&extras=url_m%2C+geo&format=json&nojsoncallback=1")

    suspend fun getImage(@Query("longitude") longitude:Double,
                         @Query("latitude")latitude:Double):Response<List<ImagesModel>>


    suspend fun fetchSinglePicture(@Url url:String): Response<ImagesModel>
}