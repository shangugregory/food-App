package com.example.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(val img:Array<Int>,
val text: Array<String>,
val desc: Array<String>,
val price: Array<String>):RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {

private lateinit var mListener: onItemClickListener
    interface onItemClickListener{

        fun onitemClick(position: Int)

    }

    fun setonItemClickListener(listener: onItemClickListener){
        mListener = listener
    }
    


    class CustomViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {

        fun bindValue(image: Int, txt: String, desc: String, price: String) {
            itemView.findViewById<ImageView>(R.id.imageView).setImageResource(image)
            itemView.findViewById<TextView>(R.id.text1).text = txt
            itemView.findViewById<TextView>(R.id.text2).text = desc
            itemView.findViewById<TextView>(R.id.price).text = price

            init{
                itemView.setOnClickListener {
                    
                }

            }
        }

        private fun init(function: () -> Unit) {

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return CustomViewHolder(v, mListener)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bindValue(img[position],text[position],desc[position], price[position])


    }

    override fun getItemCount(): Int {
        return img.size
    }
}