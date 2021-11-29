package com.example.nearmeproject.model.images


import com.google.gson.annotations.SerializedName

data class ImageModel(
    @SerializedName("photos")
    val photos: Photos
)