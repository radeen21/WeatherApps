package com.example.weatherapps.presentation.main

import androidx.databinding.ObservableField
import com.example.weatherapps.core.BaseViewModel
import javax.inject.Inject

class MainActivityViewModel @Inject internal constructor() : BaseViewModel() {
    var toolbarTitle: ObservableField<String> = ObservableField()
}
