package com.example.usecase

import com.example.entity.WeightsHistory
import com.example.repository.interfaces.WeightsHistoryRepository
import javax.inject.Inject

class GetWeightsHistoryUseCase @Inject constructor(
    private val weightsHistoryRepository: WeightsHistoryRepository
) {
    suspend operator fun invoke(id: String): WeightsHistory {
        return weightsHistoryRepository.getWeightHistory(id)
    }
}