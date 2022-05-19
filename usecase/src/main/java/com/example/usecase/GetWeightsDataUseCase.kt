package com.example.usecase

import com.example.entity.WeightsData
import com.example.repository.interfaces.WeightsRepository
import javax.inject.Inject

class GetWeightsDataUseCase @Inject constructor(
    private val weightsRepository: WeightsRepository
) {
    suspend operator fun invoke(): WeightsData {
        return weightsRepository.getWeightsData()
    }
}