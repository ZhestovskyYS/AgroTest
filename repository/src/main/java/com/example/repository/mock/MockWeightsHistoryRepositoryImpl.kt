package com.example.repository.mock

import com.example.entity.WeightsHistory
import com.example.entity.WeightsToDate
import com.example.repository.interfaces.WeightsHistoryRepository

class MockWeightsHistoryRepositoryImpl : WeightsHistoryRepository {

    private val weightsHistory = WeightsHistory(
        animalName = "Буренка",
        weightsList = listOf(
            WeightsToDate(
                date = "10.05.2020г",
                weight = "773кг"
            ),
            WeightsToDate(
                date = "11.06.2020г",
                weight = "763кг"
            ),
            WeightsToDate(
                date = "12.07.2020г",
                weight = "750кг"
            ),
            WeightsToDate(
                date = "13.08.2020г",
                weight = "753кг"
            ),
            WeightsToDate(
                date = "14.09.2020г",
                weight = "762кг"
            )
        )
    )

    override suspend fun getWeightHistory(id: String): WeightsHistory {
        return weightsHistory
    }
}