package com.example.nearme.views.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.nearme.databinding.FragmentDetalisImageBinding
import com.squareup.picasso.Picasso

// this fragment is for presenting the details of each image when clicked
class detailfragment : Fragment() {

   private lateinit var binding:FragmentDetalisImageBinding
    val oneimageviewmodel:ImageViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentDetalisImageBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observers()
        oneimageviewmodel.fetchphotodetails()

    }

    fun observers()
    {
        oneimageviewmodel.oneimagelivedata.observe(viewLifecycleOwner,{
            Picasso.get().load(it.url).into(binding.imageItem)
            binding.imageCity.text=it.title
            binding.imageDistance.text=it.dateupload
            Log.d("dfd",binding.imageCity.text.toString())

        })
    }





}