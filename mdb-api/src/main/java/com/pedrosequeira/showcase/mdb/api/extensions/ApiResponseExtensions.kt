package com.pedrosequeira.showcase.mdb.api.extensions

fun Int?.orZero() = this ?: 0

fun Boolean?.orFalse() = this ?: false

fun Boolean?.orTrue() = this ?: true

fun Double?.orZero() = this ?: 0.0
