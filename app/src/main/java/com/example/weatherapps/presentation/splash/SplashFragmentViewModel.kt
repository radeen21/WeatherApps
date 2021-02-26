package com.example.weatherapps.presentation.splash

import android.content.SharedPreferences
import com.example.weatherapps.core.BaseViewModel
import javax.inject.Inject

class SplashFragmentViewModel @Inject constructor(var sharedPreferences: SharedPreferences) : BaseViewModel() {
    var navigateDashboard = false
}
