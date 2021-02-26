package com.example.weatherapps.presentation.dashboard.forecast

import androidx.databinding.ObservableField
import com.example.weatherapps.core.BaseViewModel
import com.example.weatherapps.domain.model.ListItem
import javax.inject.Inject

class ForecastItemViewModel @Inject internal constructor() : BaseViewModel() {
    var item = ObservableField<ListItem>()
}
