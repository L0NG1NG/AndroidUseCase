package com.longing.dialogs

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ViewConfiguration
import androidx.appcompat.widget.AppCompatImageView

class DragView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : AppCompatImageView(context, attrs) {
    private val minDistance = ViewConfiguration.get(context).scaledTouchSlop
    var isDrag = true


    private var lastX = 0
    private var lastY = 0
    override fun onTouchEvent(event: MotionEvent): Boolean {
        return if (isDrag) {
            val x = event.x.toInt()
            val y = event.y.toInt()
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    isDrag = false
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    val offsetY = y - lastY
                    layout(left, top + offsetY, right, bottom + offsetY)
                    true
                }
                MotionEvent.ACTION_UP -> {
                    isDrag = false
                    true
                }

                else -> true
            }


        } else super.onTouchEvent(event)
    }




}