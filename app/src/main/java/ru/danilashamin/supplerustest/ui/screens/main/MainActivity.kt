package ru.danilashamin.supplerustest.ui.screens.main

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import ru.danilashamin.supplerustest.App
import ru.danilashamin.supplerustest.R
import ru.danilashamin.supplerustest.base.ActivityBase
import ru.danilashamin.supplerustest.presentation.main.MainPresenter
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

class MainActivity : ActivityBase(), MainView {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @InjectPresenter
    lateinit var mainPresenter: MainPresenter

    private val navigator = SupportAppNavigator(this, R.id.mainContainer)

    override fun onCreate(savedInstanceState: Bundle?) {
        App.instance.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun provideLayoutResId(): Int = R.layout.activity_main

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        mainPresenter.onBackPressed()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
