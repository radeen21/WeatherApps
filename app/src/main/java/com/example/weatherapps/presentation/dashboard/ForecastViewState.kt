package com.example.weatherapps.presentation.dashboard

import com.example.weatherapps.core.BaseViewState
import com.example.weatherapps.db.entity.ForecastEntity
import com.example.weatherapps.utils.domain.Status

class ForecastViewState(
    val status: Status,
    val error: String? = null,
    val data: ForecastEntity? = null
) : BaseViewState(status, error) {
    fun getForecast() = data
}
