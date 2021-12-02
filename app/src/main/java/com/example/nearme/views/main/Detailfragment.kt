package com.example.nearme.views.main

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.media.Image
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.Images.Media.insertImage
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.nearme.databinding.FragmentDetalisImageBinding
import com.example.nearme.model.images.Photo
import com.squareup.picasso.Picasso
import java.io.ByteArrayOutputStream

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

        //savedInstanceState!!.getParcelable<Photo>("key")
        //for clicking on the share image


        binding.shareImage.setOnClickListener {

            val image:Bitmap?= getBitmapFromView(binding.imageItem)
            val share= Intent(Intent.ACTION_SEND)
            share.type="image/*"
            share.putExtra(Intent.EXTRA_STREAM,getImageUri(requireActivity(),image!!))
            startActivity(Intent.createChooser(share, "Share Via:"))

        }

    }

    /// those two functions for sharing the pic

    private fun getBitmapFromView(view: ImageView):Bitmap?{
        val bitmap= Bitmap.createBitmap(view.width,view.height,Bitmap.Config.ARGB_8888)
        val paint=Canvas(bitmap)
        view.draw(paint)
        return bitmap

    }
    private fun getImageUri(inContext:Context, inImage:Bitmap): Uri?{
        val byte=ByteArrayOutputStream()
        inImage.compress(Bitmap.CompressFormat.JPEG,100,byte)
        val path= MediaStore.Images.Media.insertImage(inContext.contentResolver,inImage,"Title",null)
        return Uri.parse(path)

    }


    fun observers()
    {
        oneimageviewmodel.oneimagelivedata.observe(viewLifecycleOwner, {

            Picasso.get().load(it.url).into(binding.imageItem)
            binding.imageTitle.text=it.title
            binding.imageDistance.text="${it.datetaken}"
            Log.d("dfd",binding.imageTitle.text.toString())
        })
//        oneimageviewmodel.oneImageErrorLiveData.observe(viewLifecycleOwner,{
//           it?.let {
//               Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
//               oneimageviewmodel.oneImageErrorLiveData.postValue(null)
//           }
//
//        })
    }





}