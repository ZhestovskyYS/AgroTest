package com.example.agrotest.presentation.diagram

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.entity.AnimalsWeightsHistory
import com.example.entity.RepositoryResult
import com.example.usecase.GetDiagramDataUseCase
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class DiagramViewModel @Inject constructor(
    private val router: Router,
    private val getDiagramDataUseCase: GetDiagramDataUseCase
) : ViewModel() {

    private val _diagramData =
        MutableStateFlow<RepositoryResult<AnimalsWeightsHistory>>(RepositoryResult.Initial())
    val diagramData: StateFlow<RepositoryResult<AnimalsWeightsHistory>> get() = _diagramData

    fun getDiagramData(animalsIds: List<String>) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _diagramData.value = RepositoryResult.Loading()
                val result = getDiagramDataUseCase(animalsIds)
                _diagramData.value = RepositoryResult.Success(result)
            } catch (e: Exception) {
                _diagramData.value = RepositoryResult.Error(e.localizedMessage)
            }
        }
    }

    fun navigateBack() {
        router.exit()
    }
}
