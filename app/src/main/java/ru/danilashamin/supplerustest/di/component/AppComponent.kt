package ru.danilashamin.supplerustest.di.component

import dagger.Component
import ru.danilashamin.supplerustest.di.module.ApiModule
import ru.danilashamin.supplerustest.di.module.AppModule
import ru.danilashamin.supplerustest.ui.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ApiModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}
