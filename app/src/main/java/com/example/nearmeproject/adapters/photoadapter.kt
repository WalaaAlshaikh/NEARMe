package com.example.nearmeproject.adaptersimport

 import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
 import android.widget.ImageView
 import com.example.nearmeproject.R
 import com.example.nearmeproject.model.Photo
 import com.example.nearmeproject.model.Photos
 import com.squareup.picasso.Picasso

class photoadapter(private val list: List<Photo>) :
    RecyclerView.Adapter<photoadapter.photoviewholder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): photoadapter.photoviewholder {
        return photoviewholder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: photoviewholder, position: Int) {
        val item = list[position]
        Picasso.get().load(item.urlM).into(holder.image)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class photoviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image:ImageView=itemView.findViewById(R.id.animage)
    }
}