//package com.example.nearme.database
//
//import androidx.room.Dao
//import androidx.room.Query
//import com.example.nearme.model.images.ImageModel
//import com.example.nearme.model.images.Photo
//import com.example.nearme.model.images.Photos
//@Dao
//interface  FavoriteDao {
//    @Query("SELECT * FROM Photo WHERE isFavorite")
//        suspend fun getPhotoFavorite(): List<Photo>
//
//    }