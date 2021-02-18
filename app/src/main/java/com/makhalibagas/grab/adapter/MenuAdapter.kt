package com.makhalibagas.grab.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.makhalibagas.grab.R
import com.makhalibagas.grab.model.Menu
import com.makhalibagas.grab.model.Ongoing
import com.makhalibagas.grab.model.Recent


class MenuAdapter(val lis : List<Menu>) : RecyclerView.Adapter<MenuAdapter.ViewHolder>() {

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        val name = v.findViewById<TextView>(R.id.tv_name)

        fun bind(menu: Menu){


            name.text = menu.name

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_menu, parent, false))
    }

    override fun getItemCount(): Int {
        return lis.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val menu = lis[position]


        holder.bind(menu)
    }
}