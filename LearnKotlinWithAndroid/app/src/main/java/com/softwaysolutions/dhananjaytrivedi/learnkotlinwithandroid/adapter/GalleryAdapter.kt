package com.softwaysolutions.dhananjaytrivedi.learnkotlinwithandroid.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.softwaysolutions.dhananjaytrivedi.learnkotlinwithandroid.R
import com.softwaysolutions.dhananjaytrivedi.learnkotlinwithandroid.model.UnsplashDataModel
import com.softwaysolutions.dhananjaytrivedi.learnkotlinwithandroid.util.showToastMessage
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.gallery_single_list_item.view.*

class GalleryAdapter (val context : Context,val imagesList : List<UnsplashDataModel>): RecyclerView.Adapter<GalleryAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.gallery_single_list_item, parent,  false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imagesList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = imagesList[position]
        holder.setData(item)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener{
                showToastMessage(
                    context,
                    "Clicked on the Image"
                )
            }
        }

        fun setData(item: UnsplashDataModel) {
            itemView.authorNameTV.text = item.imageAuthorName
            Picasso.get().load(item.imageThumbURL).into(itemView.galleryIV)
        }
    }
}