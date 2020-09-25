package com.doni.multistatemenu

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.motion.widget.MotionLayout

class MotionInsideMotion
@JvmOverloads constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int = 0) :
    MotionLayout(context, attrs, defStyleAttr), MotionLayout.TransitionListener {

    var isTransitionStart = false

    override fun onAttachedToWindow() {
        (parent as? MotionLayout)?.setTransitionListener(this)
        super.onAttachedToWindow()
    }

    override fun onTransitionStarted(p0: MotionLayout?, startId: Int, endId: Int) {
        isTransitionStart = startId == R.id.start
    }

    override fun onTransitionChange(p0: MotionLayout?, startId: Int, endId: Int, progress: Float) {
        if(isTransitionStart){
            this.progress = progress
        }
    }

    override fun onTransitionCompleted(m: MotionLayout?, position: Int) {
        if(isTransitionStart){
            progress = m?.progress ?: 0f
        }
        isTransitionStart = false
    }

    override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
        println("Trigger")
    }
}