package com.pedrosequeira.showcase.core.formatters

import kotlin.math.floor

fun Int.formatRunTime(): String {
    val hours = floor(this / 60.0).toInt()
    val minutes = this % 60
    return "$hours:$minutes"
}
