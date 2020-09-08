package com.example.tryjetpack.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tryjetpack.R
import com.example.tryjetpack.modal.Dress
import kotlinx.android.synthetic.main.list_item.view.*
import java.util.ArrayList

class EthnicWearAdapter(var context:Context,var ethnicWearList:ArrayList<Dress>) : RecyclerView.Adapter<EthnicWearAdapter.EthnicViewHolder>() {

    class EthnicViewHolder(var itemView1: View) : RecyclerView.ViewHolder(itemView1) {
        var textView1 = itemView1.priceTextView
        var textView2 = itemView1.nameTextView
        var imageView1 = itemView1.dressImageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EthnicViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return EthnicViewHolder(view)
    }

    override fun getItemCount(): Int {
        return ethnicWearList.size
    }

    override fun onBindViewHolder(holder: EthnicViewHolder, position: Int) {


        holder.textView1.text = ethnicWearList[position].price
        holder.textView2.text = ethnicWearList[position].name
        holder.imageView1.setImageDrawable( ethnicWearList[position].imageView)
    }
}