package ru.danilashamin.supplerustest.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import ru.danilashamin.supplerustest.base.moxy.MvpAppCompatFragment
import ru.danilashamin.supplerustest.ui.screens.loading.LoadingDialogFragment
import ru.danilashamin.supplerustest.utils.Constants.LOADING_DIALOG_TAG

abstract class FragmentBase : MvpAppCompatFragment(), ViewBase {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(provideLayoutRes(), container, false)
    }

    @LayoutRes
    abstract fun provideLayoutRes(): Int

    override fun showMessage(message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        if (!hasLoadingDialog()) {
            LoadingDialogFragment.newInstance().show(childFragmentManager, LOADING_DIALOG_TAG)
        }
    }

    override fun hideLoading() {
        if (hasLoadingDialog()) {
            (childFragmentManager?.findFragmentByTag(LOADING_DIALOG_TAG) as? LoadingDialogFragment)?.dismiss()
        }
    }

    private fun hasLoadingDialog() = childFragmentManager.findFragmentByTag(LOADING_DIALOG_TAG) == null
}