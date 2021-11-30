package com.example.nearmeproject.views.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.nearmeproject.R
import com.example.nearmeproject.databinding.FragmentDetalisImageBinding
import com.squareup.picasso.Picasso


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
        oneimageviewmodel.oneimagelivedata.observe(viewLifecycleOwner, {

            Picasso.get().load(it.urlM).into(binding.imageItem)
            binding.imageCity.text=it.title
            Log.d("dfd",binding.imageCity.text.toString())
        })
    }





}