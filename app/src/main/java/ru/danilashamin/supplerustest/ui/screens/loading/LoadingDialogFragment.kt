package ru.danilashamin.supplerustest.ui.screens.loading

import ru.danilashamin.supplerustest.R
import ru.danilashamin.supplerustest.base.DialogFragmentBase

class LoadingDialogFragment : DialogFragmentBase() {
    companion object{
        fun newInstance() = LoadingDialogFragment()
    }
    override fun provideLayoutResId(): Int = R.layout.dialog_fragment_loading
}