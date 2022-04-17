package com.keytop.kaf

import android.app.Application
import com.keytop.android.apphelper.KtAndroidAppHelper
import com.keytop.android.apphelper.log.KtLog

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        KtAndroidAppHelper.init(this)
        KtLog.setIsShowLog(BuildConfig.DEBUG)
        KtLog.setAutoJumpLogInfos(false)
        KtLog.i("----Application Start----")
    }
}