package ru.danilashamin.supplerustest.di.component

import dagger.Component
import ru.danilashamin.supplerustest.di.module.ApiModule
import ru.danilashamin.supplerustest.di.module.AppModule
import ru.danilashamin.supplerustest.di.module.NavigationModule
import ru.danilashamin.supplerustest.di.module.UtilsModule
import ru.danilashamin.supplerustest.presentation.main.MainPresenter
import ru.danilashamin.supplerustest.presentation.project.ProjectPresenter
import ru.danilashamin.supplerustest.presentation.projects.ProjectsPresenter
import ru.danilashamin.supplerustest.ui.custom.MarginItemDecoration
import ru.danilashamin.supplerustest.ui.screens.main.MainActivity
import ru.danilashamin.supplerustest.utils.image.ImageLoader
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ApiModule::class, NavigationModule::class, UtilsModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)

    fun inject(mainPresenter: MainPresenter)

    fun inject(projectsPresenter: ProjectsPresenter)

    fun inject(marginItemDecoration: MarginItemDecoration)

    fun inject(projectPresenter: ProjectPresenter)

    fun inject(imageFetcher: ImageLoader.ImageFetcher)
}
