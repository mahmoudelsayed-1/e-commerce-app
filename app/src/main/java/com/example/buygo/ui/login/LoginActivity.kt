package com.example.buygo.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.buygo.databinding.ActivityLoginBinding
import com.example.buygo.ui.Events
import com.example.buygo.ui.home.HomeActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onStart() {
        super.onStart()
        viewModel.checkTokenOnStart()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        subscribeToLiveData()
    }


    private fun subscribeToLiveData() {
        viewModel.showLoading.observe(this) { show ->
            viewBinding.loginProgress.isVisible = show
        }
        viewModel.errorLiveData.observe(this) { message ->
            AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton("Ok", null)
                .show()

        }
        viewModel.events.observe(this) {
            when (it) {
                Events.NavigateToHome -> {
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                }

                else -> {

                }
            }
        }


    }

    private fun initViews() {
        viewBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        viewBinding.lifecycleOwner = this
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        viewBinding.vm = viewModel
    }
}