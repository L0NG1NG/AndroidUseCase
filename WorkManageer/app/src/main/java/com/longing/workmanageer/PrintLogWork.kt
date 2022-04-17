package com.longing.workmanageer

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.keytop.android.apphelper.log.KtLog

class PrintLogWork(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {
    private var data: Long = 0

    override fun onStopped() {
        super.onStopped()
        KtLog.i("onStopped: -->$data")
    }

    override fun doWork(): Result {
        val url = inputData.getString("IMAGE_URI")
        KtLog.i("新建一个新的任务$url")
        while (!isStopped) {
            data++
            Thread.sleep(1000)
            KtLog.i("doWork: -->$data")
        }
        return Result.success()
    }

}