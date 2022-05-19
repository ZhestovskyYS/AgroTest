package com.example.usecase

import com.example.entity.TableRowData
import com.example.repository.interfaces.ReportsRepository
import javax.inject.Inject

class GetTableDataUseCase @Inject constructor(
    private val repository: ReportsRepository
) {
    suspend operator fun invoke() : List<TableRowData> {
        return repository.getTableRowData()
    }
}