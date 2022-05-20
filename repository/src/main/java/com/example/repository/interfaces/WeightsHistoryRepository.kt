package com.example.repository.interfaces

import com.example.entity.WeightsHistory

interface WeightsHistoryRepository {
    suspend fun getWeightHistory(id: String): WeightsHistory
}