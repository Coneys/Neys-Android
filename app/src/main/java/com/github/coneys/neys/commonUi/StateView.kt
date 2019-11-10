package com.github.coneys.neys.commonUi

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.core.view.isGone
import com.github.coneys.neys.R
import com.github.coneys.neys.extensions.layoutInflater
import com.jaredrummler.android.widget.AnimatedSvgView
import kotlinx.android.synthetic.main.view_progress.view.*

class StateView(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {
    private val errorView: View = layoutInflater.inflate(R.layout.view_error, this, true).also {
        it.isGone = true
    }
    private val progressView: View =
        layoutInflater.inflate(R.layout.view_progress, this, true).also {
            it.isGone = false
        }

    fun render(iconRes: Int, messageRes: Int) {

    }

    fun renderProgress() {
        animated_svg_view.start()
        animated_svg_view.setOnStateChangeListener {
            if (it == AnimatedSvgView.STATE_FINISHED) {
                animated_svg_view.start()
            }
        }
    }

    fun hide(){
        stopProgress()
    }

    private fun stopProgress(){
        animated_svg_view.setOnStateChangeListener(null)
        animated_svg_view.reset()
    }
}