package com.softwaysolutions.dhananjaytrivedi.learnkotlinwithandroid.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.softwaysolutions.dhananjaytrivedi.learnkotlinwithandroid.R
import com.softwaysolutions.dhananjaytrivedi.learnkotlinwithandroid.activity.WallpaperActivity
import com.softwaysolutions.dhananjaytrivedi.learnkotlinwithandroid.model.UnsplashDataModel
import com.softwaysolutions.dhananjaytrivedi.learnkotlinwithandroid.util.WALLPAPER_URL
import kotlinx.android.synthetic.main.gallery_single_list_item.view.*

class GalleryAdapter(val context: Context, val imagesList: List<UnsplashDataModel>) :
    RecyclerView.Adapter<GalleryAdapter.MyViewHolder>() {

    // Default Implemented Methods onCreateViewHolder() getItemCount() onBindViewHolder()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.gallery_single_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imagesList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = imagesList[position]
        holder.setData(item)
    }

    // Inner View Holder Class
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // To handle onClick for each Image View we setup a listener inside the init { } block of our ViewHolder Class
        init {
            itemView.setOnClickListener {
                val intent = Intent(context, WallpaperActivity::class.java)
                intent.putExtra(WALLPAPER_URL, imagesList[adapterPosition].imageThumbURL)
                context.startActivity(intent)
            }
        }

        // Populating each View
        internal fun setData(item: UnsplashDataModel) {
            itemView.authorNameTV.text = item.imageAuthorName
            Glide.with(context).load(item.imageThumbURL).into(itemView.galleryIV)
        }
    }
}