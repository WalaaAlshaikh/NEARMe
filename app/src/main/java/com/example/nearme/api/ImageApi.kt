package com.example.nearme.api

import com.example.nearme.model.images.ImageModel
import com.example.nearme.model.images.Photo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageApi {
    @GET("/services/rest/?method=flickr.photos.search&api_key=9e5f12168b375780422f42def7e7c339&extras=url_m,geo,date_upload,date_taken&per_page=10&format=json&nojsoncallback=1")
   // getImage function for fetching the list of the images from the api (putting Latitude and Longitude as Queries)
   suspend fun getImage(
        @Query("lat") lat:Double,
        @Query("lon")lon:Double):Response<ImageModel>

    // fetchSinglePicture function for fetching one image form the api to get it in the detail fragment
    suspend fun fetchSinglePicture(): Response<Photo>


}