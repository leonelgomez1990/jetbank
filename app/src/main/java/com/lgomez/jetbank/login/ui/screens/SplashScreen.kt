package com.lgomez.jetbank.login.ui.screens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import com.lgomez.jetbank.R
import com.lgomez.jetbank.core.ui.compose.DefaultScreen
import com.lgomez.jetbank.login.ui.viewmodels.SplashViewModel
import com.lgomez.jetbank.login.ui.views.SplashView
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(viewModel: SplashViewModel) {
    val scaleAnimation: Animatable<Float, AnimationVector1D> =
        remember { Animatable(initialValue = 0f) }

    LaunchedEffect(key1 = true) {
        scaleAnimation.animateTo(
            targetValue = 0.5F,
            animationSpec = tween(
                durationMillis = 1500,
                easing = {
                    OvershootInterpolator(3F).getInterpolation(it)
                }
            )
        )

        delay(timeMillis = 3000L)
        viewModel.goToSignIn()
    }

    DefaultScreen {
        SplashView(
            imagePainter = painterResource(
                id =
                R.drawable.mana_logo
            ),
            scaleAnimation = scaleAnimation
        )
    }
}