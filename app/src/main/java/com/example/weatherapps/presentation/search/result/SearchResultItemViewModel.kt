package com.example.weatherapps.presentation.search.result

import androidx.databinding.ObservableField
import com.example.weatherapps.core.BaseViewModel
import com.example.weatherapps.db.entity.CitiesForSearchEntity
import javax.inject.Inject

class SearchResultItemViewModel @Inject internal constructor() : BaseViewModel() {
    var item = ObservableField<CitiesForSearchEntity>()
}
