package com.makhalibagas.grab.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.makeramen.roundedimageview.RoundedImageView
import com.makhalibagas.grab.R
import com.makhalibagas.grab.model.Discover
import kotlinx.android.synthetic.main.item_promo.view.*

class DiscoverAdapter(val lis : List<Discover>) : RecyclerView.Adapter<DiscoverAdapter.ViewHolder>() {

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        val iv = v.findViewById<RoundedImageView>(R.id.iv_promo)
        val name = v.findViewById<TextView>(R.id.tv_name)
        val date = v.findViewById<TextView>(R.id.tv_date)

        fun bind(discover: Discover){
            Glide.with(itemView.context).load(discover.iv).into(iv)
            name.text = discover.name
            date.text = discover.date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_promo, parent, false))
    }

    override fun getItemCount(): Int {
        return lis.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val discover = lis[position]
        holder.bind(discover)
    }
}