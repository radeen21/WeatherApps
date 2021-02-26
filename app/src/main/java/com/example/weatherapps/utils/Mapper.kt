package com.example.weatherapps.utils

interface Mapper<R, D> {
    fun mapFrom(type: R): D
}