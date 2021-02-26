package com.example.weatherapps.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.weatherapps.core.Constant
import com.example.weatherapps.db.entity.CurrentWeatherEntity
import com.example.weatherapps.presentation.dashboard.CurrentWeatherViewState
import com.example.weatherapps.repo.CurrentWeatherRepository
import com.example.weatherapps.utils.UseCaseLiveData
import com.example.weatherapps.utils.domain.Resource
import javax.inject.Inject

class CurrentWeatherUseCase @Inject internal constructor(private val repository: CurrentWeatherRepository) : UseCaseLiveData<CurrentWeatherViewState, CurrentWeatherUseCase.CurrentWeatherParams, CurrentWeatherRepository>() {

    override fun getRepository(): CurrentWeatherRepository {
        return repository
    }

    override fun buildUseCaseObservable(params: CurrentWeatherParams?): LiveData<CurrentWeatherViewState> {
        return repository.loadCurrentWeatherByGeoCords(
            params?.lat?.toDouble() ?: 0.0,
            params?.lon?.toDouble() ?: 0.0,
            params?.fetchRequired
                ?: false,
            units = params?.units ?: Constant.Coords.METRIC
        ).map {
            onCurrentWeatherResultReady(it)
        }
    }

    private fun onCurrentWeatherResultReady(resource: Resource<CurrentWeatherEntity>): CurrentWeatherViewState {
        return CurrentWeatherViewState(
            status = resource.status,
            error = resource.message,
            data = resource.data
        )
    }

    class CurrentWeatherParams(
        val lat: String = "",
        val lon: String = "",
        val fetchRequired: Boolean,
        val units: String
    ) : Params()
}
