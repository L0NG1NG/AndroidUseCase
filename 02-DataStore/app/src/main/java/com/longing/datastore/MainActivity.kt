package com.longing.datastore

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.createDataStore
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var dataStore: DataStore<Preferences>
    private var taskNmae = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dataStore = application.createDataStore("my_datastore")
        findViewById<Button>(R.id.read_data).setOnClickListener {
            //读数据
            lifecycleScope.launch {
                dataStore.data.collect { prefers ->
                    val taskName = prefers[PreferencesKeys.TASK_NAME] ?: "00"
                    Log.d(TAG, "task name-->$taskName")
                    val isCompleted = prefers[PreferencesKeys.SHOW_COMPLETED] ?: false
                    Log.d(TAG, "task is completed: -->$isCompleted")

                }
            }
        }

        findViewById<Button>(R.id.write_data).setOnClickListener {
            //写数据
            lifecycleScope.launch(Dispatchers.IO) {
                updateTask("打印机")
            }

        }
    }

    private suspend fun updateTask(name: String) {
        dataStore.edit { prefers ->
            prefers[PreferencesKeys.SHOW_COMPLETED] = true

        }
    }


}