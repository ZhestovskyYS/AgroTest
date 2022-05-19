package com.example.repository.interfaces

import com.example.entity.WeightsData

interface WeightsRepository {
    suspend fun getWeightsData(): WeightsData
}