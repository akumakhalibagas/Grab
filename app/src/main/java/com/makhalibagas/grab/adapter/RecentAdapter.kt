package com.makhalibagas.grab.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.makhalibagas.grab.R
import com.makhalibagas.grab.model.Ongoing
import com.makhalibagas.grab.model.Recent


class RecentAdapter(val lis : List<Recent>) : RecyclerView.Adapter<RecentAdapter.ViewHolder>() {

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        val name = v.findViewById<TextView>(R.id.tv_name)
        val desc = v.findViewById<TextView>(R.id.tv_desc)
        val harga = v.findViewById<TextView>(R.id.tv_harga)

        fun bind(recent: Recent){


            name.text = recent.name
            desc.text = recent.desc
            harga.text = recent.harga

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_recent, parent, false))
    }

    override fun getItemCount(): Int {
        return lis.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val recent = lis[position]


        holder.bind(recent)
    }
}