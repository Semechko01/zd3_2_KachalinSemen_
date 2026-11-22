package com.example.zd3_2_kachalinsemen

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class viewfilm : Activity() {
    private lateinit var pref : SharedPreferences
    private lateinit var image : ImageView
    private lateinit var title : TextView
    private lateinit var desc : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewfilm)
        image = findViewById(R.id.image_pp)
        title = findViewById(R.id.name_pp)
        desc = findViewById(R.id.des_pp)

        pref = getSharedPreferences("film", Context.MODE_PRIVATE)
        Picasso.get().load(pref.getString("image",null)).into(image)
        title.setText(pref.getString("title",null));
        desc.setText(pref.getString("desc",null));

    }
}