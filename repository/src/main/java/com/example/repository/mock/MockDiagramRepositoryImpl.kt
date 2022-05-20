package com.example.repository.mock

import com.example.entity.AnimalsWeightsHistory
import com.example.entity.WeightsHistory
import com.example.entity.WeightsToDate
import com.example.repository.interfaces.DiagramRepository

class MockDiagramRepositoryImpl : DiagramRepository {

    private val data = AnimalsWeightsHistory(
        value = listOf(
            WeightsHistory(
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
            ),
            WeightsHistory(
                animalName = "Муренка",
                weightsList = listOf(
                    WeightsToDate(
                        date = "10.05.2020г",
                        weight = "720кг"
                    ),
                    WeightsToDate(
                        date = "11.06.2020г",
                        weight = "680кг"
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
            ),
            WeightsHistory(
                animalName = "Сизушка",
                weightsList = listOf(
                    WeightsToDate(
                        date = "10.05.2020г",
                        weight = "640кг"
                    ),
                    WeightsToDate(
                        date = "11.06.2020г",
                        weight = "710кг"
                    ),
                    WeightsToDate(
                        date = "12.07.2020г",
                        weight = "730кг"
                    ),
                    WeightsToDate(
                        date = "13.08.2020г",
                        weight = "753кг"
                    ),
                    WeightsToDate(
                        date = "14.09.2020г",
                        weight = "750кг"
                    )
                )
            )
        )
    )

    override suspend fun getDiagramData(animalsIds: List<String>): AnimalsWeightsHistory {
        return data
    }
}