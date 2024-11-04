package com.example.recyclerviewpict

import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewpict.databinding.ItemPictureBinding

class PictureAdapter (private val listPicture: List<Picture>) :
    RecyclerView.Adapter<PictureAdapter.PictureViewHolder>() {

    inner class PictureViewHolder(private val binding: ItemPictureBinding) :
            RecyclerView.ViewHolder(binding.root) {

                fun bind(picture: Picture) {
                    with(binding) {
                        imgKendaraan.setImageResource(picture.drawableResId)
                        txtKendaraanDescription.text = picture.description
                    }
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder {
        val binding = ItemPictureBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return PictureViewHolder(binding)
    }

    override fun getItemCount(): Int {

        return listPicture.size
    }

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        holder.bind(listPicture[position])
    }
}