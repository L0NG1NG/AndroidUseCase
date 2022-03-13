package com.longing.datastore

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object PreferencesKeys {
    val SHOW_COMPLETED = booleanPreferencesKey("show_completed")
    val TASK_NAME = stringPreferencesKey("task_name")

}