package com.example.weatherapps.domain.datasource.currentWeather

import com.example.weatherapps.domain.WeatherAppApi
import com.example.weatherapps.domain.model.CurrentWeatherResponse
import io.reactivex.Single
import javax.inject.Inject

class CurrentWeatherRemoteDataSource @Inject constructor(private val api: WeatherAppApi) {

    fun getCurrentWeatherByGeoCords(lat: Double, lon: Double, units: String): Single<CurrentWeatherResponse> = api.getCurrentByGeoCords(lat, lon, units)
}
