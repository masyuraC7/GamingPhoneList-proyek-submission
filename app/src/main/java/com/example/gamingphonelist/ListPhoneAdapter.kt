package com.example.gamingphonelist

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gamingphonelist.databinding.ItemRowPhoneBinding


class ListPhoneAdapter (private val listPhone: ArrayList<Phone>) :
    RecyclerView.Adapter<ListPhoneAdapter.ListViewHolder>() {

    class ListViewHolder (var binding: ItemRowPhoneBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int ) : ListViewHolder {
        val binding = ItemRowPhoneBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, varian, description, osVersion, layar, screen, processor, ram, rom,
            kameraBelakang, kameraUtamaLn, kameraDepan, nfc,
            usb, baterai, img) = listPhone[position]

        Glide.with(holder.itemView.context).load(img).into(holder.binding.ivImgPhone)
        holder.binding.txtTitle.text = name
        holder.binding.txtVarian.text = varian
        val maxLength = 80
        val shortDescription = description.substring(0, maxLength)
        holder.binding.txtDescription.text = "$shortDescription..."
        holder.itemView.setOnClickListener{
            val moveToDetailPageIntent = Intent(holder.itemView.context,
                DetailPhoneActivity::class.java)
            moveToDetailPageIntent.putExtra("key_phone", listPhone[holder.adapterPosition])
            holder.itemView.context.startActivity(moveToDetailPageIntent)
        }
        holder.binding.btnDetail.setOnClickListener{
            val detailIntent = Intent(holder.itemView.context, DetailPhoneActivity::class.java)
            detailIntent.putExtra("key_phone", listPhone[holder.adapterPosition])
            holder.itemView.context.startActivity(detailIntent)
        }
    }

    override fun getItemCount(): Int = listPhone.size

}