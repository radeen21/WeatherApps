package com.example.weatherapps.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapps.di.ViewModelFactory
import com.example.weatherapps.di.key.ViewModelKey
import com.example.weatherapps.presentation.dashboard.DashboardFragmentViewModel
import com.example.weatherapps.presentation.dashboard.forecast.ForecastItemViewModel
import com.example.weatherapps.presentation.main.MainActivityViewModel
import com.example.weatherapps.presentation.search.SearchViewModel
import com.example.weatherapps.presentation.search.result.SearchResultItemViewModel
import com.example.weatherapps.presentation.splash.SplashFragmentViewModel
import com.example.weatherapps.presentation.weather_detail.WeatherDetailViewModel
import com.example.weatherapps.presentation.weather_detail.weatherHourOfDay.WeatherHourOfDayItemViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @IntoMap
    @Binds
    @ViewModelKey(SplashFragmentViewModel::class)
    abstract fun provideSplashFragmentViewModel(splashFragmentViewModel: SplashFragmentViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun provideMainViewModel(mainActivityViewModel: MainActivityViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(DashboardFragmentViewModel::class)
    abstract fun provideDashboardFragmentViewModel(dashboardFragmentViewModel: DashboardFragmentViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(ForecastItemViewModel::class)
    abstract fun provideForecastItemViewModel(forecastItemViewModel: ForecastItemViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(WeatherDetailViewModel::class)
    abstract fun provideWeatherDetailViewModel(weatherDetailViewModel: WeatherDetailViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(WeatherHourOfDayItemViewModel::class)
    abstract fun provideWeatherHourOfDayItemViewModel(weatherHourOfDayItemViewModel: WeatherHourOfDayItemViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(SearchViewModel::class)
    abstract fun provideSearchViewModel(searchViewModel: SearchViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(SearchResultItemViewModel::class)
    abstract fun provideSearchResultItemViewModel(searchResultItemViewModel: SearchResultItemViewModel): ViewModel
}
