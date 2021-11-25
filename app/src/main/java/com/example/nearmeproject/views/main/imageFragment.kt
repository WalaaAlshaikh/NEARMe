package com.example.nearmeproject.views.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.nearmeproject.R
import com.example.nearmeproject.adaptersimport.ImageAdapter
import com.example.nearmeproject.model.images.ImageModel
import com.example.nearmeproject.model.images.Photo


class imageFragment : Fragment() {

    private val imageViewModel:ImageViewModel by activityViewModels()
    private val list= mutableListOf<Photo>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView =view.findViewById(R.id.recyclerView1)
        val adapter= ImageAdapter(imageViewModel)
        recyclerView.adapter=adapter
        imageViewModel.callImage()



        imageViewModel.imageLiveData.observe(viewLifecycleOwner,{
            adapter.submittedList(it.photos.photo)
            imageViewModel.callImage()

        })

        

    }


}