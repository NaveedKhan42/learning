package com.naveed.mytestlibrary.extension

fun String.isValidEmail() : Boolean {
    if(!this.isNullOrEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches())
        return true
    return false
}