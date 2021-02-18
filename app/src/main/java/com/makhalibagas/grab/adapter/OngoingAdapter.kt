package com.makhalibagas.grab.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.makhalibagas.grab.R
import com.makhalibagas.grab.model.Ongoing


class OngoingAdapter(val lis : List<Ongoing>) : RecyclerView.Adapter<OngoingAdapter.ViewHolder>() {

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        val name = v.findViewById<TextView>(R.id.tv_name)
        val desc = v.findViewById<TextView>(R.id.tv_desc)
        val view = v.findViewById<View>(R.id.view)

        fun bind(ongoing: Ongoing){


            name.text = ongoing.name

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_ongoing, parent, false))
    }

    override fun getItemCount(): Int {
        return lis.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ongoing = lis[position]

        val expanded = ongoing.expand
        holder.desc.visibility = if (expanded) View.VISIBLE else View.GONE
        holder.name.setOnClickListener {

            val expand : Boolean = ongoing.expand
            ongoing.expand = !expand
            holder.view.visibility = if (expand) View.GONE else View.VISIBLE
            notifyItemChanged(position)

        }
        holder.bind(ongoing)
    }
}