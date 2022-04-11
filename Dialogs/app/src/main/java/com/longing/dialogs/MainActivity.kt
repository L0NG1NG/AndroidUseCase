package com.longing.dialogs

import android.os.Bundle
import android.view.Gravity
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.longing.dialogs.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var ui: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivityMainBinding.inflate(layoutInflater)
        setContentView(ui.root)
        ui.topDialog.setOnClickListener {
            MaterialDialog(this).show {
                customView(R.layout.dialog_incomming_call)
                maxWidth()
                window?.let {
                    val lp = WindowManager.LayoutParams()
                    lp.copyFrom(it.attributes)
                    lp.width = 280
                    lp.height = 500

                    it.attributes = lp
                }

            }
        }
        ui.bottomDialog.setOnClickListener {
            CallPermissionPopup(this).setBackGroundLevel(0.8f)
                .showAtLocation(ui.root, Gravity.BOTTOM, 0, 0)
        }
    }
}