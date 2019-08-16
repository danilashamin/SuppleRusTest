package ru.danilashamin.supplerustest.di.module

import android.content.res.Resources
import dagger.Module
import dagger.Provides
import ru.danilashamin.supplerustest.utils.MessageService
import javax.inject.Singleton

@Module
class UtilsModule {
    @Singleton
    @Provides
    fun provideMessageService(resources: Resources) = MessageService(resources)
}