package com.example.weatherapps.presentation.dashboard

import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.TransitionInflater
import com.example.weatherapps.R
import com.example.weatherapps.core.BaseFragment
import com.example.weatherapps.core.Constant
import com.example.weatherapps.databinding.FragmentDashboardBinding
import com.example.weatherapps.di.Injectable
import com.example.weatherapps.domain.model.ListItem
import com.example.weatherapps.domain.usecase.CurrentWeatherUseCase
import com.example.weatherapps.domain.usecase.ForecastUseCase
import com.example.weatherapps.presentation.dashboard.forecast.ForecastAdapter
import com.example.weatherapps.presentation.main.MainActivity
import com.example.weatherapps.utils.extensions.isNetworkAvailable
import com.example.weatherapps.utils.extensions.observeWith

class DashboardFragment : BaseFragment<DashboardFragmentViewModel, FragmentDashboardBinding>(R.layout.fragment_dashboard, DashboardFragmentViewModel::class.java),
    Injectable {

    override fun init() {
        super.init()
        initForecastAdapter()
        sharedElementReturnTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)

        val lat: String? = binding.viewModel?.sharedPreferences?.getString(Constant.Coords.LAT, "")
        val lon: String? = binding.viewModel?.sharedPreferences?.getString(Constant.Coords.LON, "")

        if (lat?.isNotEmpty() == true && lon?.isNotEmpty() == true) {
            binding.viewModel?.setCurrentWeatherParams(CurrentWeatherUseCase.CurrentWeatherParams(lat, lon, isNetworkAvailable(requireContext()), Constant.Coords.METRIC))
            binding.viewModel?.setForecastParams(ForecastUseCase.ForecastParams(lat, lon, isNetworkAvailable(requireContext()), Constant.Coords.METRIC))
        }

        binding.viewModel?.getForecastViewState()?.observeWith(
            viewLifecycleOwner
        ) {
            with(binding) {
                viewState = it
                it.data?.list?.let { forecasts -> initForecast(forecasts) }
                (activity as MainActivity).viewModel.toolbarTitle.set(it.data?.city?.getCityAndCountry())
            }
        }

        binding.viewModel?.getCurrentWeatherViewState()?.observeWith(
            viewLifecycleOwner
        ) {
            with(binding) {
                containerForecast.viewState = it
            }
        }
    }

    private fun initForecastAdapter() {
        val adapter = ForecastAdapter { item, cardView, forecastIcon, dayOfWeek, temp, tempMaxMin ->
            val action = DashboardFragmentDirections.actionDashboardFragmentToWeatherDetailFragment(item)
            findNavController()
                .navigate(
                    action,
                    FragmentNavigator.Extras.Builder()
                        .addSharedElements(
                            mapOf(
                                cardView to cardView.transitionName,
                                forecastIcon to forecastIcon.transitionName,
                                dayOfWeek to dayOfWeek.transitionName,
                                temp to temp.transitionName,
                                tempMaxMin to tempMaxMin.transitionName
                            )
                        )
                        .build()
                )
        }

        binding.recyclerForecast.adapter = adapter
        binding.recyclerForecast.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        postponeEnterTransition()
        binding.recyclerForecast.viewTreeObserver
            .addOnPreDrawListener {
                startPostponedEnterTransition()
                true
            }
    }

    private fun initForecast(list: List<ListItem>) {
        (binding.recyclerForecast.adapter as ForecastAdapter).submitList(list)
    }
}
