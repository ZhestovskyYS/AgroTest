package com.example.entity

data class WeightsData(
    val rfid: String,
    val group: String,
    val location: String,
    val currentWeight: String,
    val previousWeight: String,
    val nextWeight: String
)
