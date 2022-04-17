package com.longing.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "my_datastore")

object PreferencesKeys {
    val SHOW_COMPLETED = booleanPreferencesKey("show_completed")
    val TASK_NAME = stringPreferencesKey("task_name")

}