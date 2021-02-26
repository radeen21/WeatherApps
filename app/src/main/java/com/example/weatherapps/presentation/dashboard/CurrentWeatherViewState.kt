package com.example.weatherapps.presentation.dashboard

import com.example.weatherapps.core.BaseViewState
import com.example.weatherapps.db.entity.CurrentWeatherEntity
import com.example.weatherapps.utils.domain.Status

class CurrentWeatherViewState(
    val status: Status,
    val error: String? = null,
    val data: CurrentWeatherEntity? = null
) : BaseViewState(status, error) {
    fun getForecast() = data
}
