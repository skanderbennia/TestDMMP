package com.example.testdmmp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testdmmp.R
import com.example.testdmmp.models.Planet
import kotlinx.android.synthetic.main.row_layout.view.*

class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>(){


    private var myList = emptyList<Planet>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.itemView.titleText.text = myList[position].title
        holder.itemView.infoText.text = myList[position].info
        Glide.with(holder.itemView).load(myList[position].url).into(holder.itemView.urlImage)

    }

    fun setData(newList: List<Planet>){
        myList = newList
        notifyDataSetChanged()
    }
}