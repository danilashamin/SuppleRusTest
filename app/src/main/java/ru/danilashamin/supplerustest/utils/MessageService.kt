package ru.danilashamin.supplerustest.utils

import android.content.res.Resources
import ru.danilashamin.supplerustest.R

class MessageService(private val resources: Resources) {
    fun getErrorOnRequestMessage() = resources.getString(R.string.error_occured)
}