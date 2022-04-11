package com.longing.workmanageer

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

private const val TAG = "PrintLogWork"

class PrintLogWork(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {
    private var data: Long = 0

    override fun onStopped() {
        super.onStopped()
        Log.i(TAG, "onStopped: -->$data")
    }

    override fun doWork(): Result {
        val url = inputData.getString("IMAGE_URI")
        Log.i(TAG, "新建一个新的任务$url")
        while (!isStopped) {
            data++
            Thread.sleep(1000)
            Log.i(TAG, "doWork: -->$data")
        }
        return Result.success()
    }

}