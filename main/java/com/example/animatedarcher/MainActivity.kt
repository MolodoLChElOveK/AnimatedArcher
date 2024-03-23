package com.example.animatedarcher

import androidx.appcompat.app.AppCompatActivity
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var mAnimation: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image = findViewById<ImageView>(R.id.ivAnimator)
        var i = 0
        val alphaSeekBar = findViewById<SeekBar>(R.id.sbAlpha)
        alphaSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                mAnimation.alpha = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        image.setBackgroundResource(R.drawable.archer)
        mAnimation = image.background as AnimationDrawable

        findViewById<Button>(R.id.btnChangeAnim).setOnClickListener {
            if (i == 3) {i = 0}
            when(i){
                0 -> image.setBackgroundResource(R.drawable.bird)
                1 -> image.setBackgroundResource(R.drawable.squirrel)
                2 -> image.setBackgroundResource(R.drawable.archer)
            }
            mAnimation = image.background as AnimationDrawable
            i++
        }

        findViewById<Button>(R.id.btnStart).setOnClickListener { mAnimation.start() }
        findViewById<Button>(R.id.btnStop).setOnClickListener { mAnimation.stop() }

    }
}