package com.longing.datastore

import android.content.ComponentCallbacks2
import android.os.Bundle
import android.os.Debug
import android.util.Log
import android.webkit.WebView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import java.text.DecimalFormat

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity(), ComponentCallbacks2 {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button).setOnClickListener {
            lifecycleScope.launch {
                kkk()
            }
        }

        val web = WebView(this.applicationContext)
        web.loadUrl()
    }


    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
    }

    private fun kkk() {
        val allocated = Debug.getNativeHeapAllocatedSize().toDouble() / 1048576
        val available = Debug.getNativeHeapSize().toDouble() / 1048576.0
        val free = (Debug.getNativeHeapFreeSize()) / 1048576.0
        val df = DecimalFormat()
        df.maximumFractionDigits = 2
        df.minimumFractionDigits = 2

        Log.d(TAG, "debug. =================================")
        Log.d(
            TAG, "debug.heap native: allocated "
                    + df.format(allocated) + "MB of "
                    + df.format(available) +
                    "MB (" + df.format(free) + "MB free)"
        )
        Log.d(
            TAG, "debug.memory: allocated: "
                    + df.format(Runtime.getRuntime().totalMemory().toDouble() / 1048576) +
                    "MB of " + df.format(Runtime.getRuntime().maxMemory().toDouble() / 1048576) +
                    "MB (" + df.format(
                Runtime.getRuntime().freeMemory().toDouble() / 1048576
            ) + "MB free)"
        )
    }
}