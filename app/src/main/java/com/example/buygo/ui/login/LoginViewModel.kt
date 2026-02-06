package com.example.buygo.ui.login

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.buygo.data.api.ApiManager
import com.example.buygo.data.dataSource.loginDataSource.SigninDataSource
import com.example.buygo.data.dataSource.loginDataSource.SigninOnlineDataSourceImpl
import com.example.buygo.data.repository.loginRepository.SigninRepositoryImpl
import com.example.buygo.ui.Events
import com.example.common.SingleLiveEvent
import kotlinx.coroutines.launch
import retrofit2.HttpException

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    val loginEmailLiveData = MutableLiveData<String?>()
    val loginPasswordLiveData = MutableLiveData<String?>()
    val loginEmailErrorLiveData = MutableLiveData<String?>()
    val loginPasswordErrorLiveData = MutableLiveData<String?>()
    val showLoading = MutableLiveData<Boolean>()
    val errorLiveData = MutableLiveData<String?>()
    val events = SingleLiveEvent<Events>()
    private val onlineDataSource: SigninDataSource =
        SigninOnlineDataSourceImpl(ApiManager().getApi(), application)
    val repository = SigninRepositoryImpl(onlineDataSource)


    fun login() {
        if (!validateLogin()) return
        viewModelScope.launch {
            showLoading.postValue(true)
            try {
                val response =
                    repository.signIn(loginEmailLiveData.value, loginPasswordLiveData.value)
                events.postValue(Events.NavigateToHome)
                Log.e("TAG", response.message ?: "login failed")

            } catch (e: HttpException) {
                errorLiveData.postValue(e.localizedMessage)

            } catch (ex: Exception) {
                errorLiveData.postValue(ex.localizedMessage)
            } finally {
                showLoading.postValue(false)
            }

        }

    }

    private fun validateLogin(): Boolean {
        var isValid = true
        if (loginEmailLiveData.value.isNullOrBlank()) {
            loginEmailErrorLiveData.postValue("enter email")
            isValid = false
        } else {
            loginEmailErrorLiveData.postValue(null)
        }

        if (loginPasswordLiveData.value.isNullOrBlank()) {
            loginPasswordErrorLiveData.postValue("enter password")
            isValid = false
        } else {
            loginPasswordErrorLiveData.postValue(null)
        }
        return isValid

    }

    fun checkTokenOnStart() {
        viewModelScope.launch {
            val token = repository.getSavedToken()
            if (token != "") {
                events.postValue(Events.NavigateToHome)
            } else {
                events.postValue(Events.NavigateToLogin)
            }
        }
    }
}