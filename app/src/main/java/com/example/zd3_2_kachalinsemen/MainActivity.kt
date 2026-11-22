package com.example.zd3_2_kachalinsemen

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var timer = object : CountDownTimer(3000,1000){
            override fun onTick(p0: Long) {

            }

            override fun onFinish() {
                var intent = Intent(this@MainActivity,QuestsActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        timer.start()
    }
}