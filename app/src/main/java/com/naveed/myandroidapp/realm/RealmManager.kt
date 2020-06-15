package com.naveed.myandroidapp.realm

import io.realm.Realm
import io.realm.RealmObject


class RealmManager {

    /**
     * Insert/Updates the model data using Realm
     */
    fun <T : RealmObject> add(model: T) {
        val realm = Realm.getDefaultInstance()
        realm.executeTransaction { realm1 ->
            realm1.insertOrUpdate(model)
        }
        realm.close()
    }

    /**
     * Checks Realm DB for username and password combination
     */
    inline fun <reified T : RealmObject> findAll(name:String, password:String ): List<T> {
        val realm = Realm.getDefaultInstance()
        val list = realm.copyFromRealm(
            realm.where(T::class.java).equalTo("name",name).and().equalTo("password",password)
                .findAll())
        realm.close()
        return list
    }
}