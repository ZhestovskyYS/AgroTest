package com.example.repository.mock

import com.example.entity.WeightsData
import com.example.repository.interfaces.WeightsRepository

class MockWeightsRepositoryImpl : WeightsRepository {

    private val weightsData = WeightsData(
        rfid = "885496132",
        group = "группа 1",
        location = "Стойло №3",
        currentWeight = "772кг",
        previousWeight = "765кг",
        nextWeight = "720кг"
    )

    override suspend fun getWeightsData(): WeightsData {
        return weightsData
    }
}