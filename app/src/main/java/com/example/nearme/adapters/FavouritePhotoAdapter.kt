//package com.example.nearme.adaptersimport
//
//import androidx.recyclerview.widget.RecyclerView
//import com.example.nearme.model.images.Photo
//
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.annotation.NonNull
//import androidx.recyclerview.widget.AsyncListDiffer
//import androidx.recyclerview.widget.DiffUtil
//import com.example.nearme.databinding.FavoriteImageLayoutBinding
//import com.squareup.picasso.Picasso
//
//class FavoritePhotoAdapter(private val list: List<Photo>) :
//    RecyclerView.Adapter<FavoriteImageAdapter.FavoriteImageViewHolder>() {
//    val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Photo>(){
//        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
//             return oldItem.isFavorite == newItem.isFavorite
//        }
//
//        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
//            return oldItem == newItem
//        }
//    }
//    private val differ = AsyncListDiffer(this,DIFF_CALLBACK)
//    fun sumbitList(list: List<Photo>){
//        differ.submitList(list)
//    }
//    override fun onCreateViewHolder(
//        parent: ViewGroup,
//        viewType: Int
//    ): FavoriteImageAdapter.FavoriteImageViewHolder {
//        val binding = FavoriteImageLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
//
//        return FavoriteImageViewHolder(binding)
//
//    }
//
//    override fun onBindViewHolder(holder: FavoriteImageViewHolder, position: Int) {
//        val item = list[position]
//        holder.bind(item)
//    }
//
//    override fun getItemCount(): Int {
//        return list.size
//    }
//
//    class FavoriteImageViewHolder(val binding: FavoriteImageLayoutBinding): RecyclerView.ViewHolder(binding.root) {
//        fun bind(item: Photo) {
//
//           Picasso.get().load(item.imagePath).into(binding.favoriteImageView)
//
//        }
//    }
//}