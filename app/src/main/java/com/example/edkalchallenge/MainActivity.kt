package com.example.edkalchallenge

import android.animation.AnimatorSet
import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.edkalchallenge.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var lightAnimations: AnimatorSet
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.viewModel = mainViewModel
        binding.lifecycleOwner = this

        mainViewModel.colorLiveData.observe(this, Observer { ledColor ->
            val colorFrom = if (ledColor.isFlashing) ContextCompat.getColor(this, R.color.colorWhite) else ledColor.colorRes
            val colorTo = ledColor.colorRes

            //Flashing light animation
            val colorAnimation = ValueAnimator.ofObject(ArgbEvaluator(), colorFrom, colorTo).apply {
                repeatCount = ledColor.duration
                duration = 1000
                addUpdateListener {
                    imageView1.setBackgroundColor(it.animatedValue as Int)
                }
            }

            //Animation replicating turning the light off
            val backToNormalAnimation = ValueAnimator.ofObject(ArgbEvaluator(), colorTo,
                ContextCompat.getColor(this, R.color.colorWhite)).apply {
                addUpdateListener {
                    imageView1.setBackgroundColor(it.animatedValue as Int)
                    mainViewModel.enableButtons()
                }
                duration = 1000
            }

            //Combination of both animations
            lightAnimations = AnimatorSet().apply {
                play(colorAnimation).before(backToNormalAnimation)
                start()
            }
        })
    }

    fun turnLightOff(view: View) {
        lightAnimations.end()
        mainViewModel.enableButtons()
    }
}
