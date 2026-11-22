package com.example.zd3_2_kachalinsemen

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class QuestRecycler(val context: Context,val list: ArrayList<Quests>) : RecyclerView.Adapter<QuestRecycler.MyVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVH {
        val root = LayoutInflater.from(context).inflate(R.layout.element, parent, false)
        return MyVH(root)
    }

    class MyVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image_quests)
        val title: TextView = itemView.findViewById(R.id.title_quests)
        val descr: TextView = itemView.findViewById(R.id.descr)
    }


    override fun onBindViewHolder(holder: MyVH, position: Int) {
        Picasso.get().load(list[position].image).placeholder(R.drawable.background).into(holder.imageView)
        holder.title.text = list[position].title
        holder.descr.text = list[position].text

        holder.imageView.setOnClickListener {
            val pref = context.getSharedPreferences("film", Context.MODE_PRIVATE)
            pref.edit()
                .putString("image", list[position].image)
                .putString("title", list[position].title)
                .putString("desc", list[position].text)
                .apply()
            context.startActivity(Intent(context, viewfilm::class.java))
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}