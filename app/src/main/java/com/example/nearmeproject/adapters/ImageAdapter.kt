package com.example.nearmeproject.adaptersimport

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.nearmeproject.R
import com.example.nearmeproject.databinding.ItemLayoutBinding
import com.example.nearmeproject.model.images.ImageModel
import com.example.nearmeproject.model.images.Photo
import com.example.nearmeproject.model.images.Photos
import com.example.nearmeproject.views.main.ImageViewModel
import com.example.nearmeproject.views.main.imageFragment
import com.squareup.picasso.Picasso
import kotlinx.coroutines.withContext

class ImageAdapter(val image:ImageViewModel) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    val DIFF_CALLBACK=object:DiffUtil.ItemCallback<Photo>(){


        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem==newItem
        }

    }
    private val differ= AsyncListDiffer(this,DIFF_CALLBACK)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImageAdapter.ImageViewHolder {
        val binding=ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val item = differ.currentList[position]
        holder.bind(item)
        //val manager=(holder.itemView.context as FragmentActivity).supportFragmentManager
        holder.itemView.setOnClickListener {

            image.oneimagelivedata.postValue(item)
            holder.itemView.findNavController().navigate(R.id.action_imageFragment_to_detailfragment)

        }
//        Picasso.get().load(item.urlM).into(holder.image1)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submittedList(list:List<Photo>){
        differ.submitList(list)

    }

    class ImageViewHolder(val binding:ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item:Photo){
            Picasso.get().load(item.urlM).into(binding.imageView1)

        }



    }
}