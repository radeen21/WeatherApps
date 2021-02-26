package com.example.weatherapps.di.module

import com.example.weatherapps.presentation.main.MainActivity
import com.example.weatherapps.di.scope.PerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {


    @PerActivity
    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    internal abstract fun mainActivity(): MainActivity
}
