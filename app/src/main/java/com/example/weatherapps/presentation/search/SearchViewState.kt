package com.example.weatherapps.presentation.search

import com.example.weatherapps.core.BaseViewState
import com.example.weatherapps.db.entity.CitiesForSearchEntity
import com.example.weatherapps.utils.domain.Status

class SearchViewState(
    val status: Status,
    val error: String? = null,
    val data: List<CitiesForSearchEntity>? = null
) : BaseViewState(status, error) {
    fun getSearchResult() = data
}
