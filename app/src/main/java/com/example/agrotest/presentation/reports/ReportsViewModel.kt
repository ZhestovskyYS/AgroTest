package com.example.agrotest.presentation.reports

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.entity.RepositoryResult
import com.example.entity.TableRowData
import com.example.usecase.GetTableDataUseCase
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class ReportsViewModel @Inject constructor(
    private val router: Router,
    private val getTableDataUseCase: GetTableDataUseCase
): ViewModel() {

    private val _tableData = MutableStateFlow<RepositoryResult<List<TableRowData>>>(RepositoryResult.Initial())
    val tableData: StateFlow<RepositoryResult<List<TableRowData>>> get() = _tableData

    fun getTableData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _tableData.value = RepositoryResult.Loading()
                val result = getTableDataUseCase()
                _tableData.value = RepositoryResult.Success(result)
            } catch (e: Exception) {
                _tableData.value = RepositoryResult.Error(e.localizedMessage)
            }
        }
    }

    fun navigateBack() {
        router.exit()
    }

    fun navigateToDetailsGraphic(rowData: TableRowData) {
        //TODO("Not yet implemented")
    }
}