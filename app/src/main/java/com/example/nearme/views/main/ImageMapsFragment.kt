package com.example.nearme.views.main

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.nearme.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

private const val TAG = "ImageMapsFragment"

class ImageMapsFragment : Fragment(),OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    lateinit var googleMap: GoogleMap
    lateinit var lastLocation: Location
    lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private val imageViewModel:ImageViewModel by activityViewModels()


    private val callback = OnMapReadyCallback { googleMaps ->

        googleMap = googleMaps
        googleMap.uiSettings.isZoomControlsEnabled=true
        googleMap.setOnMarkerClickListener (this)
        googleMaps.setOnMapClickListener {
            googleMaps.clear()
            val marker = MarkerOptions().position(it)
            googleMap.addMarker(marker)
            Log.d(TAG, "click: lat: ${it.latitude}, long: ${it.longitude}")
            imageViewModel.mapcall(imageViewModel.lat,imageViewModel.long)
            imageViewModel.lat=it.latitude
            imageViewModel.long=it.longitude

            var bundle= bundleOf("Lat" to  imageViewModel.lat,"Long" to imageViewModel.long)

            findNavController().navigate(R.id.action_imageMapsFragment2_to_imageFragment2,bundle)

        }
        fetchMap()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        return inflater.inflate(R.layout.fragment_image_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?

        mapFragment?.getMapAsync(callback)

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(requireActivity())

      //  fetchMap()
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            101 -> fetchMap()
        }
    }

    fun fetchMap() {
        if (ActivityCompat.checkSelfPermission(
                requireActivity(),
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(requireActivity(), android.Manifest.permission.ACCESS_COARSE_LOCATION)
            == PackageManager.PERMISSION_GRANTED
        ) {

            googleMap.isMyLocationEnabled = true

            fusedLocationProviderClient.lastLocation.addOnSuccessListener {

                if (it != null) {

                    lastLocation = it
                    imageViewModel.lat=it.latitude
                    imageViewModel.long=it.longitude
                    var currentloc = LatLng(imageViewModel.lat, imageViewModel.long)

                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentloc, 12f))
                    val marker = MarkerOptions().position(currentloc)
                    googleMap.addMarker(marker)

                    googleMap.setOnMyLocationClickListener {
                        googleMap.clear()
                        lastLocation = it
                        imageViewModel.lat=it.latitude
                        imageViewModel.long=it.longitude
//                        var currentloc = LatLng(imageViewModel.lat, imageViewModel.long)
                        Log.d(TAG, "click: lat: ${it.latitude}, long: ${it.longitude}")
                        imageViewModel.mapcall(it.latitude,it.longitude)

                        imageViewModel.lat=it.latitude
                        imageViewModel.long=it.longitude

                            var bundle= bundleOf("Lat" to  imageViewModel.lat,"Long" to imageViewModel.long)

                        findNavController().navigate(R.id.action_imageMapsFragment2_to_imageFragment2,bundle)

                    }


                }else{
                    Log.d("tag", "messahes")
                }

            }

        } else{
            Toast.makeText(requireActivity(), "You need to allow the permission of using your location", Toast.LENGTH_LONG).show()
        }


    }

    override fun onMapReady(p0: GoogleMap) {

    }

    override fun onMarkerClick(p0: Marker)=true
}
