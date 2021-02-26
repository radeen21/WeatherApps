package com.example.weatherapps.domain.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Rain(

    @Json(name = "3h")
    val jsonMember3h: Double?
) : Parcelable
