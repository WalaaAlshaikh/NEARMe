package com.example.nearme.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nearme.model.images.Photo

@Dao
interface PhotoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhotos(Photo:List<Photo>)

    @Query("SELECT * FROM photo")
    suspend fun getPhoto(): List<Photo>



}