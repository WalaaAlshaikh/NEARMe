package com.example.nearmeproject.model


import com.google.gson.annotations.SerializedName

data class photojson(
    @SerializedName("photos")
    val photos: Photos
)