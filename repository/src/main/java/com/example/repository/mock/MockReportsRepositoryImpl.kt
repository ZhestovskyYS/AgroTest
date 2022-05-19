package com.example.repository.mock

import com.example.entity.TableRowData
import com.example.repository.interfaces.ReportsRepository

class MockReportsRepositoryImpl : ReportsRepository {

    private val tableDataList = listOf(
        TableRowData(
            animal = "Мурка",
            currentWeight = "700кг",
            previousWeight = "702кг",
            deltaWeight = "2кг"
        ),
        TableRowData(
            animal = "Буренка",
            currentWeight = "680кг",
            previousWeight = "698кг",
            deltaWeight = "18кг"
        ),
        TableRowData(
            animal = "Белка",
            currentWeight = "720кг",
            previousWeight = "721кг",
            deltaWeight = "1кг"
        ),TableRowData(
            animal = "Аленка",
            currentWeight = "730кг",
            previousWeight = "735кг",
            deltaWeight = "5кг"
        ),TableRowData(
            animal = "Муренка",
            currentWeight = "750кг",
            previousWeight = "766кг",
            deltaWeight = "16кг"
        )
    )

    override suspend fun getTableRowData(): List<TableRowData> {
        return tableDataList
    }
}