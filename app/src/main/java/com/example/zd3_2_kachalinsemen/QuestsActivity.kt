package com.example.zd3_2_kachalinsemen

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.android.volley.Request
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.squareup.picasso.Picasso
import org.json.JSONObject

class QuestsActivity : Activity() {
    private lateinit var but : Button
    private lateinit var but2 : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quests)
        val rec: RecyclerView = findViewById(R.id.recyclers)
        rec.layoutManager = GridLayoutManager(this,3)
        but = findViewById(R.id.search_button)
        but2 = findViewById(R.id.edittes)
        val listw = arrayListOf<Quests>()


        val movies = listOf("Matrix", "Inception", "Interstellar", "Avatar", "Titanic", "Joker", "Gladiator", "Dune", "Up")
        for(i in 0..8) {
            val queue = Volley.newRequestQueue(this)
            var key = "1dd9cc86"
            var url = "https://www.omdbapi.com/?apikey=$key&t=${movies[i]}"
            val stringRequest = StringRequest(
                Request.Method.GET, url,
                { response ->
                    val g = i;
                    Log.d("MyLog", "Current")
                    val obj = JSONObject(response)
                    val title = obj.getString("Title")
                    val description = obj.getString("Plot")
                    val posterUrl = obj.getString("Poster")
                    Log.d("MyLog", "Current Download")
                    val kk = Quests(posterUrl, title, description)
                    listw.add(kk)
                    if(listw.count() == 9)
                        rec.adapter = QuestRecycler(this,listw)

                },
                {
                    Log.d("MyLog", "Volley Error: $it")
                }
            )
            queue.add(stringRequest)

        }
        but.setOnClickListener {
            val eed = but2.text.toString()
            if(eed.length == 0)
            {
                rec.adapter = QuestRecycler(this,listw)
                return@setOnClickListener
            }
            val listw2 = arrayListOf<Quests>()
            for(i in 0..8)
            {
                if(eed == listw[i].title )
                {
                    listw2.add(listw[i])
                    break;
                }
            }
            rec.adapter = QuestRecycler(this,listw2)
        }

    }
}