package com.pedrosequeira.showcase.core.providers

import android.content.Context
import androidx.annotation.StringRes
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class StringProvider @Inject constructor(
    @ApplicationContext private val context: Context
) {

    fun getString(@StringRes id: Int): String {
        return context.getString(id)
    }
}
