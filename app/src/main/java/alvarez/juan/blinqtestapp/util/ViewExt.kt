package alvarez.juan.blinqtestapp.util

import android.animation.Animator
import android.content.Context
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.Toast

fun View.hideView(animated: Boolean = false, animDuration: Long = 300) {
    if (animated) {
        val viewAnimator = animate()
            .alpha(0f)
            .setDuration(animDuration)
            .setInterpolator(AccelerateDecelerateInterpolator())
            .setListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(p0: Animator) {}
                override fun onAnimationCancel(p0: Animator) {}
                override fun onAnimationRepeat(p0: Animator) {}
                override fun onAnimationEnd(animator: Animator) {
                    visibility = View.GONE
                    animator.removeAllListeners()
                }
            })

        viewAnimator.start()
    } else {
        visibility = View.GONE
    }
}

fun View.showView(animated: Boolean = false, animDuration: Long = 300) {
    if (animated) {
        val viewAnimator = animate()
            .alpha(1f)
            .setDuration(animDuration)
            .setInterpolator(AccelerateDecelerateInterpolator())
            .setListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(p0: Animator) {}
                override fun onAnimationCancel(p0: Animator) {}
                override fun onAnimationRepeat(p0: Animator) {}
                override fun onAnimationEnd(animator: Animator) {
                    visibility = View.VISIBLE
                    animator.removeAllListeners()
                }
            })

        viewAnimator.start()
    } else {
        visibility = View.VISIBLE
    }
}

fun Toast.showToast(text: String, context: Context) {
    Toast.makeText(
        context,
        text,
        Toast.LENGTH_SHORT
    ).show()
}