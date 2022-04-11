package com.longing.workmanageer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.work.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.start).setOnClickListener {
            val workRequest = OneTimeWorkRequest.Builder(PrintLogWork::class.java)
                .setInputData(Data.Builder().putString("IMAGE_URI", "LongLongLong").build())
                .build()
            WorkManager.getInstance(this).enqueueUniqueWork(
                "printLog", ExistingWorkPolicy.REPLACE,
                workRequest
            )
        }

    }
}