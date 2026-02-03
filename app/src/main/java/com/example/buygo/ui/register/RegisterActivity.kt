package com.example.buygo.ui.register

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.buygo.R
import com.example.buygo.databinding.ActivityRegisterBinding
import com.example.buygo.ui.login.LoginActivity

class RegisterActivity : AppCompatActivity() {
    lateinit var viewModel: RegisterViewModel
    lateinit var viewBinding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        subscribeLiveData()

    }

    private fun subscribeLiveData() {
        viewModel.showLoading.observe(this) { show ->
            if (show == null) return@observe
            viewBinding.progress.isVisible = show

        }

        viewModel.errorLiveData.observe(this) { message ->

            AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton("ok",null)
                .show()
        }

        viewModel.events.observe(this){
            when(it){
                RegisterEvents.NavigateToLogin -> {
                    val intent = Intent(this,LoginActivity::class.java)
                    startActivity(intent)
                }
                else ->{

                }
            }
        }
    }


    private fun initViews() {
        viewBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        viewBinding.lifecycleOwner = this
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
        viewBinding.vm = viewModel
    }
}