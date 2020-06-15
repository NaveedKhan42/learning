package com.naveed.myandroidapp.extension

/**
 * Validates the String for proper email format
 * @return boolean
 */
fun String.isValidEmail() : Boolean {
    return this.isNotBlank() && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}