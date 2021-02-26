package com.example.weatherapps.di.module

import com.example.weatherapps.presentation.dashboard.DashboardFragment
import com.example.weatherapps.presentation.search.SearchFragment
import com.example.weatherapps.presentation.splash.SplashFragment
import com.example.weatherapps.presentation.weather_detail.WeatherDetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeSplashFragment(): SplashFragment

    @ContributesAndroidInjector
    abstract fun contributeDashboardFragment(): DashboardFragment

    @ContributesAndroidInjector
    abstract fun contributeWeatherDetailFragment(): WeatherDetailFragment

    @ContributesAndroidInjector
    abstract fun contributeSearchFragment(): SearchFragment
}
