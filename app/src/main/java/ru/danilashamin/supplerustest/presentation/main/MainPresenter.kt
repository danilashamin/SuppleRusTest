package ru.danilashamin.supplerustest.presentation.main

import com.arellomobile.mvp.InjectViewState
import ru.danilashamin.supplerustest.App
import ru.danilashamin.supplerustest.base.PresenterBase
import ru.danilashamin.supplerustest.ui.screens.main.MainView
import ru.danilashamin.supplerustest.utils.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class MainPresenter : PresenterBase<MainView>() {

    @Inject
    lateinit var router: Router

    init {
        App.instance.appComponent.inject(this)
    }

    override fun onFirstViewAttach() {
        router.newRootScreen(Screens.ProjectsScreen())
    }

    fun onBackPressed() {
        router.exit()
    }
}