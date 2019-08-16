package ru.danilashamin.supplerustest.base

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import ru.danilashamin.supplerustest.base.moxy.MvpAppCompatDialogFragment

abstract class DialogFragmentBase : MvpAppCompatDialogFragment(), ViewBase {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(provideLayoutResId(), container, false)
    }

    @LayoutRes
    abstract fun provideLayoutResId(): Int

    override fun showMessage(message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    override fun onStart() {
        super.onStart()
        resizeDialog()
    }

    private fun resizeDialog() {

        val window = dialog?.window

        val activity = activity

        val displayMetrics = DisplayMetrics()
        activity?.windowManager?.defaultDisplay?.getMetrics(displayMetrics)

        displayMetrics.heightPixels
        val width = displayMetrics.widthPixels

        window?.setLayout((width * 0.95).toInt(), ViewGroup.LayoutParams.WRAP_CONTENT)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

    }

    override fun showLoading() {
//do nothing
    }

    override fun hideLoading() {
// do nothing
    }
}