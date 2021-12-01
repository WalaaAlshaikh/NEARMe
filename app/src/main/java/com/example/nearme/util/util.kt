package com.example.nearme.util

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import java.time.*
import java.time.format.DateTimeFormatter.ISO_DATE
import java.time.format.DateTimeFormatter.ofPattern
import java.util.*

class util {


@RequiresApi(Build.VERSION_CODES.O)
fun convert(datestring: String):LocalDateTime
{
val formatter= ofPattern("yyyy-MM-dd HH:mm:ss",Locale.ENGLISH)
    val parser=LocalDateTime.parse(datestring,formatter)
    return parser





}


    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SimpleDateFormat")
    fun convertlong(datelong:Long):LocalDateTime
    {
        var triggerTime =LocalDateTime.ofInstant(Instant.ofEpochSecond(datelong), TimeZone.getDefault().toZoneId())
        return triggerTime

    }

}