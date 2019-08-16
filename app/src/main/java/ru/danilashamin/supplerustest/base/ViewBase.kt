package ru.danilashamin.supplerustest.base

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface ViewBase : MvpView {

    @StateStrategyType(SkipStrategy::class)
    fun showMessage(message: String?)

    @StateStrategyType(SkipStrategy::class)
    fun showLoading()

    @StateStrategyType(SkipStrategy::class)
    fun hideLoading()
}