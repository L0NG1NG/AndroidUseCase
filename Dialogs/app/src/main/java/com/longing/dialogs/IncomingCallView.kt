package com.longing.dialogs

import android.app.Service
import android.content.ClipData
import android.content.Context
import android.os.Vibrator
import android.os.VibratorManager
import android.util.AttributeSet
import android.view.DragEvent
import android.view.LayoutInflater
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.Toast
import androidx.constraintlayout.helper.widget.Layer
import androidx.constraintlayout.widget.ConstraintLayout
import java.security.Provider


class IncomingCallView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    init {
        val rootView =
            LayoutInflater.from(context).inflate(
                R.layout.popup_incoming_call,
                this, true
            )

        initView(rootView)
    }

    private fun initView(rootView: View) {
        val layer: Layer = rootView.findViewById<Layer>(R.id.incoming_layer)
            .also { it.isClickable = true }
        val accept: ImageView = rootView.findViewById(R.id.accept_incoming)

        val toggleSpeaker = rootView.findViewById<CheckBox>(R.id.toggle_speaker)
        toggleSpeaker.setOnCheckedChangeListener { _, isCheck ->
            if (isCheck) {
                Toast.makeText(context, "声音将使用听筒播放", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(context, "声音将使用扬声器播放", Toast.LENGTH_SHORT).show()

            }
        }
        val hide: ImageView = rootView.findViewById(R.id.hide_call)

        val callingIv = rootView.findViewById<View>(R.id.show_call_layout)
        hide.setOnClickListener {
            callingIv.visibility = View.VISIBLE
            layer.visibility = View.GONE
        }


        accept.setOnClickListener {
            it.visibility = View.GONE
            hide.visibility = VISIBLE
        }
        val hangup: ImageView = rootView.findViewById(R.id.hangup)

        hangup.setOnClickListener {
            Toast.makeText(context, "挂断", Toast.LENGTH_SHORT).show()

        }
        callingIv.setOnClickListener {
            callingIv.visibility = View.GONE
            layer.visibility = View.VISIBLE
        }


        val dragView: DragView = rootView.findViewById(R.id.dragView)
        dragView.setOnLongClickListener {
            val vib = context.getSystemService(Service.VIBRATOR_SERVICE) as Vibrator
            vib.vibrate(130)
            dragView.isDrag = true
            true
        }
        dragView.setOnClickListener {
            Toast.makeText(context, "2222", Toast.LENGTH_SHORT).show()
        }
    }
}
