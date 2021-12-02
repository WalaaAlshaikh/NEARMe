package com.example.nearme.adaptersimport

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.nearme.R
import com.example.nearme.databinding.ItemLayoutBinding
import com.example.nearme.model.images.Photo
import com.example.nearme.views.main.ImageViewModel
import com.squareup.picasso.Picasso

class ImageAdapter(val image: ImageViewModel) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {
    // declaring diff_callback for DiffUtil

    val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Photo>() {


        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.id == newItem.id
        }


        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem == newItem
        }

    }
    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImageAdapter.ImageViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val item = differ.currentList[position]
        holder.bind(item)
        // for moving to another fragment when clicking on the picture to get details
        holder.itemView.setOnClickListener {

            //val bundle = Bundle()
            //bundle.putParcelable("key",item)

            image.oneimagelivedata.postValue(item)
            holder.itemView.findNavController()
                .navigate(R.id.action_imageFragment2_to_detailfragment2)

        }

    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submittedList(list: List<Photo>) {
        differ.submitList(list)

    }

    class ImageViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Photo) {
            // displaying the image in the list
            Picasso.get().load(item.url).into(binding.itemImageView)
        }


    }
}