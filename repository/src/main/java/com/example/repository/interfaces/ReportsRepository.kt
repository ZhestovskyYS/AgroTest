package com.example.repository.interfaces

import com.example.entity.TableRowData

interface ReportsRepository {
    suspend fun getTableRowData(): List<TableRowData>
}