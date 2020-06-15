package com.naveed.myandroidapp.viewmodel

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.naveed.myandroidapp.model.User
import com.naveed.myandroidapp.repository.UsersRepo

/**
 * LoginViewModel used for authentication of user from the Realm Database
 */
class LoginViewModel: ViewModel() {

    val userName = ObservableField<String>()
    val userPassword = ObservableField<String>()
    val loginResult = MutableLiveData<Boolean>()
    private val usersRepo = UsersRepo()

    fun performLogin() = loginResult.postValue(checkIfUserExists())

    private fun checkIfUserExists() : Boolean{
        val name: String = let { userName.get() }.toString()
        val password: String = let { userPassword.get() }.toString()
        val users: List<User> = usersRepo.getUser(name, password)
        if(users.isNotEmpty()){
            Log.d("Login","Validation Successful")
            return true
        }
        return false
    }

}