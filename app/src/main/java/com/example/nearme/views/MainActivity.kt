package com.example.nearme.views

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import com.example.nearme.R
import com.example.nearme.repositories.ApiRepo
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.lang.Exception

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ApiRepo.init(this)


//
//            fetchLocation()
        fusedLocationProviderClient=LocationServices.getFusedLocationProviderClient(this)
        if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_DENIED
            || ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_DENIED) {

            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 101)
            return
        }
        val currentLoc=fusedLocationProviderClient.lastLocation
        currentLoc.addOnSuccessListener {
           try {
               if(it != null ){
                   var lat=it.latitude

                   var log= it.longitude
                   Log.d(TAG, "Lat $lat Lon: $log")
           }
           }  catch (e:Exception){
               Log.d(TAG,e.message.toString())
           }
        }
}
    // fun fetchLocation() {



    //}
}







//val navhostfragment=supportFragmentManager.findFragmentById(R.id.imagenavigation) as NavHostFragment
//ده كومت من جود
//كومنت من أمل
//كومنت من ابتهال
//كومنت من وعد