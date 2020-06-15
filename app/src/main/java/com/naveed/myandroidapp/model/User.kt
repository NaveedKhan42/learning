package com.naveed.myandroidapp.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

/**
 * Realm Class for User model
 */

@RealmClass
open class User() : RealmObject(){
    @PrimaryKey
    var name: String?=""
    var email: String?=""
    var city: String?=""
    var password: String?=""
}