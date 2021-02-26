package com.example.weatherapps.domain.datasource.currentWeather

import com.example.weatherapps.db.entity.CurrentWeatherEntity
import com.example.weatherapps.db.entity.dao.CurrentWeatherDao
import com.example.weatherapps.domain.model.CurrentWeatherResponse
import javax.inject.Inject

class CurrentWeatherLocalDataSource @Inject constructor(private val currentWeatherDao: CurrentWeatherDao) {

    fun getCurrentWeather() = currentWeatherDao.getCurrentWeather()

    fun insertCurrentWeather(currentWeather: CurrentWeatherResponse) = currentWeatherDao.deleteAndInsert(
        CurrentWeatherEntity(currentWeather)
    )
}
