package com.example.weatherapps.domain.datasource.forecast

import com.example.weatherapps.db.entity.ForecastEntity
import com.example.weatherapps.db.entity.dao.ForecastDao
import com.example.weatherapps.domain.model.ForecastResponse
import javax.inject.Inject

class ForecastLocalDataSource @Inject constructor(private val forecastDao: ForecastDao) {

    fun getForecast() = forecastDao.getForecast()

    fun insertForecast(forecast: ForecastResponse) = forecastDao.deleteAndInsert(ForecastEntity(forecast))
}
