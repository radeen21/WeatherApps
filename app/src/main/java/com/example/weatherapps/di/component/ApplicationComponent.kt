package com.example.weatherapps.di.component

import android.app.Application
import com.example.weatherapps.WeatherApps
import com.example.weatherapps.di.module.ActivityModule
import com.example.weatherapps.di.module.ApplicationModule
import com.example.weatherapps.di.module.DatabaseModule
import com.example.weatherapps.di.module.NetModule
import com.example.weatherapps.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        NetModule::class,
        DatabaseModule::class,
        ActivityModule::class,
        ViewModelModule::class
    ]
)

interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(weatherApp: WeatherApps)
}
