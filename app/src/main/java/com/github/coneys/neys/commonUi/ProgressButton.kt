package com.github.coneys.neys.commonUi

import android.content.Context
import android.transition.TransitionManager
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import com.github.coneys.neys.R
import com.github.coneys.neys.extensions.layoutInflater
import com.github.coneys.neys.extensions.onClick
import kotlinx.android.synthetic.main.view_progress_button.view.*

class ProgressButton(context: Context, attrs: AttributeSet) : FrameLayout(context, attrs) {

    init {

        layoutInflater.inflate(R.layout.view_progress_button, this, true)
        renderButton()
        clipChildren = false
        clipToPadding = false

        cutomiseByAttributes(context, attrs)
    }

    private fun cutomiseByAttributes(
        context: Context,
        attrs: AttributeSet
    ) {
        val array = context.theme.obtainStyledAttributes(attrs, R.styleable.ProgressButton, 0, 0)

        try {
            val text = array.getString(R.styleable.ProgressButton_buttonText)
            progress_button_button.text = text
        } finally {
            array.recycle()
        }
    }

    var showingProgress: Boolean = false
        set(value) {
            field = value
            TransitionManager.beginDelayedTransition(this)
            if (value) {
                renderShowingProgress()
            } else {
                renderButton()
            }
        }


    fun onButtonClicked(lambda: () -> Unit) {
        progress_button_button.onClick(lambda)
    }

    private fun renderButton() {
        progress_button_progress.isGone = true
        progress_button_button.isInvisible = false
        progress_button_button.isClickable = true

    }

    private fun renderShowingProgress() {
        progress_button_button.isInvisible = true
        progress_button_button.isClickable = false
        progress_button_progress.isGone = false
    }

}