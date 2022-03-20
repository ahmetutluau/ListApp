package com.ahmetutlu.listapp.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ahmetutlu.listapp.R
import com.ahmetutlu.listapp.databinding.RecyclerRowBinding
import com.ahmetutlu.listapp.model.ListData
import com.ahmetutlu.listapp.utils.dowloadImage
import com.ahmetutlu.listapp.utils.makePlaceHolder
import com.ahmetutlu.listapp.view.ListFragmentDirections
import okhttp3.internal.Util

class RecyclerAdapter(val list: ArrayList<ListData>) :
    RecyclerView.Adapter<RecyclerAdapter.ListViewHolder>() {
    class ListViewHolder(var view: RecyclerRowBinding) : RecyclerView.ViewHolder(view.root) {

    }

    //we connect layout in below
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<RecyclerRowBinding>(
            inflater,
            R.layout.recycler_row,
            parent,
            false
        )
        return ListViewHolder(view)
    }

    //in below determined what happens when click to recycler_row
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.view.model = list[position]
        holder.view.imageView.dowloadImage(
            "https://picsum.photos/300/300?random=$position&grayscale",
            makePlaceHolder(holder.itemView.context)
        )
        holder.itemView.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToDetailsFragment(
                model = list[position],
                foto = "https://picsum.photos/300/300?random=$position&grayscale"
            )
            Navigation.findNavController(it).navigate(action)
        }

    }

    //we define how many row we'll have
    override fun getItemCount(): Int {
        return list.size
    }

    //for the adapter to renew itself when new information comes in
    fun updatedList(newList: List<ListData>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    fun deleteItem(position: Int) {
        list.removeAt(position)
        notifyDataSetChanged()

    }
    /*
     override fun imageClick(view: View, model: ListData) {
        val bundle=Bundle()
        bundle.putSerializable("model",model)
        Navigation.findNavController(view).navigate(R.id.action_listFragment_to_detailsFragment,bundle)
    }
     */
}