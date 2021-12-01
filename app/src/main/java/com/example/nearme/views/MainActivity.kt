package com.example.nearme.views

import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.nearme.R
import com.example.nearme.databinding.ActivityMainBinding
import com.example.nearme.repositories.ApiRepo
import com.example.nearme.views.main.ImageMapsFragment
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import java.lang.Exception

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // calling the function of permission in Oncreate
        checking()

        val navHostFragment=supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment

        navController=navHostFragment.navController

        // for back icon and names of fragments
        setupActionBarWithNavController(navController)

    }

    //for activation for back icon
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    // creating a function for the permission of accessing location in map
    fun checking() {
        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            )
            == PackageManager.PERMISSION_DENIED
            || ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            )
            == PackageManager.PERMISSION_DENIED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    android.Manifest.permission.ACCESS_FINE_LOCATION,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION
                ), 101
            )

        }
    }




//
//        val currentLoc=fusedLocationProviderClient.lastLocation
//        currentLoc.addOnSuccessListener {
//           try {
//               if(it != null ){
//                   var lat=it.latitude
//
//                   var log= it.longitude
//                   Log.d(TAG, "Lat $lat Lon: $log")
//           }
//           }  catch (e:Exception){
//               Log.d(TAG,e.message.toString())
//           }
//        }


}



