package com.example.repository.interfaces

import com.example.entity.AnimalsWeightsHistory

interface DiagramRepository {
    suspend fun getDiagramData(animalsIds: List<String>): AnimalsWeightsHistory
}