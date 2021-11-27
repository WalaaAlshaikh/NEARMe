package com.example.nearme.views.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.nearme.databinding.FragmentDetailfragmentBinding
import com.squareup.picasso.Picasso


class detailfragment : Fragment() {

   private lateinit var binding:FragmentDetailfragmentBinding
    val oneimageviewmodel:ImageViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentDetailfragmentBinding.inflate(layoutInflater,container,false)
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

            Picasso.get().load(it.url).into(binding.imagefordetails)
            binding.placename.text=it.title
            Log.d("dfd",binding.placename.text.toString())
        })
    }





}