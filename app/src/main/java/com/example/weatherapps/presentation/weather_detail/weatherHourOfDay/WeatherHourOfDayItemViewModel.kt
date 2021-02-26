package com.example.weatherapps.presentation.weather_detail.weatherHourOfDay

import androidx.databinding.ObservableField
import com.example.weatherapps.core.BaseViewModel
import com.example.weatherapps.domain.model.ListItem
import javax.inject.Inject

class WeatherHourOfDayItemViewModel @Inject internal constructor() : BaseViewModel() {
    var item = ObservableField<ListItem>()
}
