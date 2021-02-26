package com.example.weatherapps.di.module

import android.content.Context
import androidx.room.Room
import com.example.weatherapps.db.entity.WeatherDatabase
import com.example.weatherapps.db.entity.dao.CitiesForSearchDao
import com.example.weatherapps.db.entity.dao.CurrentWeatherDao
import com.example.weatherapps.db.entity.dao.ForecastDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun getDatabase(context: Context): WeatherDatabase {
        return Room.databaseBuilder(
            context,
            WeatherDatabase::class.java, "WeatherApp-DB"
        ).build()
    }

    @Singleton
    @Provides
    fun provideForecastDao(db: WeatherDatabase): ForecastDao {
        return db.forecastDao()
    }

    @Singleton
    @Provides
    fun provideCurrentWeatherDao(db: WeatherDatabase): CurrentWeatherDao {
        return db.currentWeatherDao()
    }

    @Singleton
    @Provides
    fun provideCitiesForSearchDao(db: WeatherDatabase): CitiesForSearchDao {
        return db.citiesForSearchDao()
    }
}
