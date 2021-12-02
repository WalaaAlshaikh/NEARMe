package com.example.nearme.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nearme.model.images.Photo

@Database(entities = [Photo ::class], version = 1)
abstract class PhotoDatabase: RoomDatabase() {

    abstract fun photoDao(): PhotoDao
}