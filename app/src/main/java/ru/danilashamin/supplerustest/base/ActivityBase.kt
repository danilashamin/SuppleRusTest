package ru.danilashamin.supplerustest.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import ru.danilashamin.supplerustest.base.moxy.MvpAppCompatActivity

abstract class ActivityBase : MvpAppCompatActivity(), ViewBase {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(provideLayoutResId())
    }

    @LayoutRes
    abstract fun provideLayoutResId(): Int

    override fun showMessage(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
//do nothing now
    }

    override fun hideLoading() {
//do nothing now
    }
}