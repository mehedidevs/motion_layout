package com.cit.k_motion_lay1

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.TranslateAnimation
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior


class MainActivity : AppCompatActivity() {
    private var isUp: Boolean = false
    private lateinit var mainLayout: LinearLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainLayout = findViewById(R.id.mainLayout)


        BottomSheetBehavior.from(mainLayout).apply {
            peekHeight = 200
            this.state = BottomSheetBehavior.STATE_COLLAPSED

        }


//        mainLayout.setOnClickListener {
//            onSlideViewButtonClick(mainLayout)
//        }


    }

    private fun justFun(name: String) {
        Log.i("TAG", "onCreate: ${name}")
    }

    // slide the view from below itself to the current position
    fun slideUp(view: View) {
        view.setVisibility(View.GONE)
        val animate = TranslateAnimation(
            0f,  // fromXDelta
            0f,  // toXDelta
            view.height.toFloat(),  // fromYDelta
            0f
        ) // toYDelta
        animate.duration = 500
        animate.fillAfter = true
        view.startAnimation(animate)
    }

    // slide the view from its current position to below itself
    fun slideDown(view: View) {
        val animate = TranslateAnimation(
            0f,  // fromXDelta
            0f,  // toXDelta
            100f,  // fromYDelta
            view.height.toFloat()
        ) // toYDelta
        animate.duration = 500
        animate.fillAfter = true
        view.startAnimation(animate)
    }

    fun onSlideViewButtonClick(view: View?) {
        if (isUp) {
            slideDown(mainLayout)
            //  myButton.setText("Slide up")
        } else {
            slideUp(mainLayout)
            // myButton.setText("Slide down")
        }
        isUp = !isUp
    }
}