package com.example.buygo.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.buygo.databinding.ActivityMainBinding
import com.example.buygo.ui.register.RegisterActivity

class MainActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        Handler(Looper.getMainLooper()).postDelayed({
           val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        },2000)
    }
}