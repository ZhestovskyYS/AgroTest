package com.example.usecase

import com.example.entity.AnimalsWeightsHistory
import com.example.repository.interfaces.DiagramRepository
import javax.inject.Inject

class GetDiagramDataUseCase @Inject constructor(
    private val diagramRepository: DiagramRepository
) {
    suspend operator fun invoke(animalsIds: List<String>): AnimalsWeightsHistory {
        return diagramRepository.getDiagramData(animalsIds)
    }
}