package com.example.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import kotlin.random.Random

private data class ConfettiParticle(
    val initialX: Float,
    val speed: Float,
    val size: Float,
    val color: Color,
    val rotationSpeed: Float
)

@Composable
fun ConfettiOverlay(
    visible: Boolean,
    onFinished: () -> Unit = {}
) {
    if (!visible) return

    val progress = remember { Animatable(0f) }

    val colors = listOf(
        Color(0xFFFF5722),
        Color(0xFFFFEB3B),
        Color(0xFF4CAF50),
        Color(0xFF2196F3),
        Color(0xFF9C27B0),
        Color(0xFFE91E63),
        Color(0xFF00BCD4)
    )

    val particles = remember {
        List(65) {
            ConfettiParticle(
                initialX = Random.nextFloat(),
                speed = 0.5f + Random.nextFloat() * 0.8f,
                size = 12f + Random.nextFloat() * 14f,
                color = colors[Random.nextInt(colors.size)],
                rotationSpeed = (Random.nextFloat() - 0.5f) * 10f
            )
        }
    }

    LaunchedEffect(visible) {
        progress.snapTo(0f)
        progress.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 2600, easing = LinearEasing)
        )
        onFinished()
    }

    Canvas(modifier = Modifier.fillMaxSize()) {
        val w = size.width
        val h = size.height
        val p = progress.value

        particles.forEach { pt ->
            val y = (pt.speed * p * (h + 100f)) - 50f
            val wobble = kotlin.math.sin((p * 15f + pt.initialX * 20f).toDouble()).toFloat() * 25f
            val x = (pt.initialX * w) + wobble

            if (y in -50f..h) {
                drawRect(
                    color = pt.color.copy(alpha = (1f - (p * 0.4f)).coerceIn(0f, 1f)),
                    topLeft = Offset(x, y),
                    size = Size(pt.size, pt.size * 0.6f)
                )
            }
        }
    }
}
