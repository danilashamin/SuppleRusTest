package ru.danilashamin.supplerustest

import android.content.Context
import androidx.annotation.IntRange
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.arellomobile.mvp.MvpAppCompatDialogFragment
import ru.danilashamin.supplerustest.di.component.AppComponent
import ru.danilashamin.supplerustest.di.component.DaggerAppComponent
import ru.danilashamin.supplerustest.di.module.AppModule

class App : MultiDexApplication() {

    companion object {
        lateinit var instance: App
            private set
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}
