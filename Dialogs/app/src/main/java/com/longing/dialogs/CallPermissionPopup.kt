package com.longing.dialogs

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.PopupWindow
import android.widget.TextView


class CallPermissionPopup(context: Context) : PopupWindow(context) {
    private val rootView: View = LayoutInflater.from(context)
        .inflate(R.layout.popup_call_permission, null, false)

    private val window: Window

    init {
        contentView = rootView
        //为了不让popup取消
        isFocusable = false
        isOutsideTouchable = false
        setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        width = WindowManager.LayoutParams.MATCH_PARENT
        height = WindowManager.LayoutParams.WRAP_CONTENT
        window = (context as Activity).window
        initView()
    }

    private fun initView() {
        rootView.findViewById<TextView>(R.id.negative).setOnClickListener {
            dismiss()
        }

    }

    override fun dismiss() {
        super.dismiss()
        setBackGroundLevel(1f)
    }

    /**
     * 设置背景灰色程度
     *
     * @param level 0.0f-1.0f
     */
    fun setBackGroundLevel(level: Float): CallPermissionPopup {
        val params: WindowManager.LayoutParams = window.attributes
        params.alpha = level
        window.attributes = params
        return this
    }
}