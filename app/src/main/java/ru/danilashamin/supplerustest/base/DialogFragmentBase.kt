package ru.danilashamin.supplerustest.base

import android.os.Bundle
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

    override fun showLoading() {
//do nothing
    }

    override fun hideLoading() {
// do nothing
    }
}