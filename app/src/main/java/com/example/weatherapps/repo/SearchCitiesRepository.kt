package com.example.weatherapps.repo

import androidx.lifecycle.LiveData
import com.example.weatherapps.core.Constant.NetworkService.RATE_LIMITER_TYPE
import com.example.weatherapps.db.entity.CitiesForSearchEntity
import com.example.weatherapps.domain.datasource.searchCities.SearchCitiesLocalDataSource
import com.example.weatherapps.domain.datasource.searchCities.SearchCitiesRemoteDataSource
import com.example.weatherapps.domain.model.SearchResponse
import com.example.weatherapps.utils.domain.RateLimiter
import com.example.weatherapps.utils.domain.Resource
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SearchCitiesRepository @Inject constructor(
    private val searchCitiesLocalDataSource: SearchCitiesLocalDataSource,
    private val searchCitiesRemoteDataSource: SearchCitiesRemoteDataSource
) {

    private val rateLimiter = RateLimiter<String>(1, TimeUnit.SECONDS)

    fun loadCitiesByCityName(cityName: String?): LiveData<Resource<List<CitiesForSearchEntity>>> {
        return object : NetworkBoundResource<List<CitiesForSearchEntity>, SearchResponse>() {
            override fun saveCallResult(item: SearchResponse) = searchCitiesLocalDataSource.insertCities(item)

            override fun shouldFetch(data: List<CitiesForSearchEntity>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun loadFromDb(): LiveData<List<CitiesForSearchEntity>> = searchCitiesLocalDataSource.getCityByName(cityName)

            override fun createCall(): Single<SearchResponse> = searchCitiesRemoteDataSource.getCityWithQuery(
                cityName
                    ?: ""
            )

            override fun onFetchFailed() = rateLimiter.reset(RATE_LIMITER_TYPE)
        }.asLiveData
    }
}
