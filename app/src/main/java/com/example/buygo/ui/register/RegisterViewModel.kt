package com.example.buygo.ui.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buygo.data.api.ApiManager
import com.example.buygo.data.dataSource.signUpDataSource.SignupDataSource
import com.example.buygo.data.dataSource.signUpDataSource.SignupOnlineDataSourceImpl
import com.example.buygo.data.repository.signUpRepository.SignupRepository
import com.example.buygo.data.repository.signUpRepository.SignupRepositoryImpl
import com.example.buygo.ui.Events
import com.example.common.SingleLiveEvent
import kotlinx.coroutines.launch
import retrofit2.HttpException

class RegisterViewModel : ViewModel() {

    val userNameLiveData = MutableLiveData<String?>()
    val emailLiveData = MutableLiveData<String?>()
    val phoneLiveData = MutableLiveData<String?>()
    val passwordLiveData = MutableLiveData<String?>()
    val rePasswordLiveData = MutableLiveData<String?>()
    val userNameErrorLiveData = MutableLiveData<String?>()
    val emailErrorLiveData = MutableLiveData<String?>()
    val phoneErrorLiveData = MutableLiveData<String?>()
    val passwordErrorLiveData = MutableLiveData<String?>()
    val rePasswordErrorLiveData = MutableLiveData<String?>()
    val showLoading = MutableLiveData<Boolean>()
    val errorLiveData = MutableLiveData<String?>()
    val events = SingleLiveEvent<Events>()
    private val onlineDataSource: SignupDataSource =
        SignupOnlineDataSourceImpl(ApiManager().getApi())
    private val signupRepository: SignupRepository = SignupRepositoryImpl(onlineDataSource)

    private fun valid(): Boolean {
        var isValid = true
        if (userNameLiveData.value.isNullOrBlank()) {
            // set error
            userNameErrorLiveData.postValue("Please Enter User Name")
            isValid = false
        } else {
            userNameErrorLiveData.postValue(null)

        }

        if (emailLiveData.value.isNullOrBlank()) {
            // set error
            emailErrorLiveData.postValue("Please Enter Email")
            isValid = false
        } else {
            emailErrorLiveData.postValue(null)

        }
        if (phoneLiveData.value.isNullOrBlank()) {
            // set error
            phoneErrorLiveData.postValue("Please Enter phone")
            isValid = false
        } else {
            phoneErrorLiveData.postValue(null)

        }

        if (passwordLiveData.value.isNullOrBlank()) {
            // set error
            passwordErrorLiveData.postValue("Please Enter User Name")
            isValid = false
        } else {
            passwordErrorLiveData.postValue(null)

        }

        if (rePasswordLiveData.value.isNullOrBlank()) {
            // set error
            rePasswordErrorLiveData.postValue("Please Enter User Name")
            isValid = false
        } else {
            rePasswordErrorLiveData.postValue(null)

        }
        return isValid
    }

    fun register() {
        if (!valid()) return
        viewModelScope.launch {
            showLoading.postValue(true)
            try {
                signupRepository.signUp(
                    userNameLiveData.value,
                    emailLiveData.value,
                    passwordLiveData.value,
                    rePasswordLiveData.value,
                    phoneLiveData.value
                )
                events.postValue(Events.NavigateToLogin)


            } catch (e: HttpException) {
                errorLiveData.postValue(e.localizedMessage)
            } catch (ex: Exception) {
                errorLiveData.postValue(ex.localizedMessage)
            } finally {
                showLoading.postValue(false)
            }


        }


    }

    fun navigateToLogin() {
        events.postValue(Events.NavigateToLogin)
    }

}