package com.example.nearme.repositories

import android.content.Context
import androidx.room.Room
import com.example.nearme.database.PhotoDatabase
import com.example.nearme.model.images.Photo

private const val DATABASE_NAME = "photo-database"

class RoomRepo (context: Context){

    private val database = Room.databaseBuilder(
        context,
        PhotoDatabase::class.java,
        DATABASE_NAME
    ).fallbackToDestructiveMigration().build()

    private val photoDao = database.photoDao()


    suspend fun insertPhoto(Photo: List<Photo>) =
        photoDao.insertPhotos(Photo)

    suspend fun getPhoto() = photoDao.getPhoto()


    companion object {
        private var instance: RoomRepo? = null

        fun init(context: Context) {
            if (instance == null)
                instance = RoomRepo(context)
        }

        fun get(): RoomRepo {
            return instance ?: throw Exception("Room Service Repository must be initialized")
        }
    }
}