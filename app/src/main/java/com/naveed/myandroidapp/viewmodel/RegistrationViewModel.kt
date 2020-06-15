package com.naveed.myandroidapp.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.naveed.myandroidapp.model.User
import com.naveed.myandroidapp.repository.UsersRepo

/**
 * RegistrationViewModel used for saving User to the Realm Database
 */
class RegistrationViewModel : ViewModel() {

    val userName = ObservableField<String>()
    val userCity = ObservableField<String>()
    val userEmail = ObservableField<String>()
    val userPassword = ObservableField<String>()
    private val usersRepo = UsersRepo()

    fun saveUserRegistrationData() {
        val user = User()
        user.name = userName.get()
        user.email = userEmail.get()
        user.city = userCity.get()
        user.password = userPassword.get()
        usersRepo.createUser(user)
    }

}