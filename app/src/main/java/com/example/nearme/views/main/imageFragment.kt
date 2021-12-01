package com.example.nearme.views.main

import android.location.Location
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.nearme.R
import com.example.nearme.adaptersimport.ImageAdapter
import com.example.nearme.databinding.FragmentImageBinding
import com.example.nearme.model.images.Photo
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.maps.model.LatLng

private const val TAG = "imageFragment"
class imageFragment : Fragment() {
    private lateinit var fused: FusedLocationProviderClient
    private lateinit var binding:FragmentImageBinding

    private val imageViewModel:ImageViewModel by activityViewModels()
    //private val list= mutableListOf<Photo>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // getting the arguments (data (Lat & Long) from ImageMapsFragment through Bundle
        if(arguments!= null)
        {
            imageViewModel.lat=requireArguments().getDouble("Lat")
            imageViewModel.long= requireArguments().getDouble("Long")
        }
        binding= FragmentImageBinding.inflate(inflater,container,false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // initializing recyclerview and assigning the adapter to it
        val recyclerView: RecyclerView =view.findViewById(R.id.Image_RecyclerView)
        // passing the imageViewModel to the adapter
        val adapter= ImageAdapter(imageViewModel)
        recyclerView.adapter=adapter
        // calling the functions from ImageViewModel and passing the data (lat & long) to them
        imageViewModel.callImage(imageViewModel.lat,imageViewModel.long)
        imageViewModel.mapcall(imageViewModel.lat,imageViewModel.long)

        //setting the observer for the live data
        imageViewModel.imageLiveData.observe(viewLifecycleOwner,{
            binding.progressBar.animate().alpha(0f)
            Log.d(TAG, "Observer: $it")
            Log.d("Blah",imageViewModel.lat.toString())
            Log.d("Blah",imageViewModel.long.toString())
            adapter.submittedList(it.photos.photo)



        })


        imageViewModel.oneImageErrorLiveData.observe(viewLifecycleOwner,{

            it?.let{
                Toast.makeText(requireActivity(), it, Toast.LENGTH_SHORT).show()
                imageViewModel.oneImageErrorLiveData.postValue(null)
            }
        })

        

    }

}