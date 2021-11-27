package com.example.nearme.model.images


import com.google.gson.annotations.SerializedName

data class ImageModel(
    @SerializedName("photos")
    val photos: Photos
)