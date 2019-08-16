package ru.danilashamin.supplerustest.base

import androidx.annotation.CallSuper
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class PresenterBase<View : ViewBase> : MvpPresenter<View>() {
    private val compositeDisposable = CompositeDisposable()

    protected fun disposeOnDestroy(d: Disposable) {
        compositeDisposable.add(d)
    }

    @CallSuper
    override fun onDestroy() {
        compositeDisposable.clear()
    }
}
