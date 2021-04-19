package com.example.listandprogress
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_view.view.*
import java.util.*
import kotlin.collections.ArrayList


class MyAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private  var items : List<Char> = ArrayList()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder)
        {
            is MyViewHolder ->{
                holder.bind(items.get(position))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return  MyViewHolder(
                LayoutInflater
                        .from(parent.context)
                        .inflate(R.layout.card_view,parent,false)
        )
    }

    override fun getItemCount(): Int {
      return  items.size
    }

    fun submitList(itemList:List<Char>)
    {
        this.items= itemList
    }

    class MyViewHolder constructor(itemview:View):RecyclerView.ViewHolder(itemview)
    {
        val card_textview = itemview.card_textView

        fun bind(char: Char)
        {
            this.card_textview.text =  "Wylosowano znak: " + char
        }
    }
}