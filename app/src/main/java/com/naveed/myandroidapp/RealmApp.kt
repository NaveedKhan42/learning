package com.naveed.myandroidapp

import android.app.Application
import android.util.Log
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Application class extension to initialize the Realm db only once
 */
class RealmApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initRealm()
    }

    /**
     * Creates Realm configuration and initializes it.
     */
    private fun initRealm(){
        Realm.init(this)
        val config = RealmConfiguration.Builder()
            .name("UsersDB")
            .schemaVersion(1)
            .deleteRealmIfMigrationNeeded()
            .build()

        Realm.setDefaultConfiguration(config)
    }
}