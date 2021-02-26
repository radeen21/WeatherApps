package com.example.weatherapps.domain.datasource.forecast

import com.example.weatherapps.domain.WeatherAppApi
import com.example.weatherapps.domain.model.ForecastResponse
import io.reactivex.Single
import javax.inject.Inject

class ForecastRemoteDataSource @Inject constructor(private val api: WeatherAppApi) {

    fun getForecastByGeoCords(lat: Double, lon: Double, units: String): Single<ForecastResponse> = api.getForecastByGeoCords(lat, lon, units)
}
