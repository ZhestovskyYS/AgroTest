package com.example.agrotest.presentation.weightshistory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.entity.RepositoryResult
import com.example.entity.WeightsHistory
import com.example.usecase.GetWeightsHistoryUseCase
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.Error
import javax.inject.Inject

class WeightsHistoryViewModel @Inject constructor(
    private val router: Router,
    private val getWeightsHistoryUseCase: GetWeightsHistoryUseCase
) : ViewModel() {

    private val _weightsHistory =
        MutableStateFlow<RepositoryResult<WeightsHistory>>(RepositoryResult.Initial())
    val weightsHistory: StateFlow<RepositoryResult<WeightsHistory>> get() = _weightsHistory

    fun getAnimalWeightsHistory(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _weightsHistory.value = RepositoryResult.Loading()
                val result = getWeightsHistoryUseCase(id)
                _weightsHistory.value = RepositoryResult.Success(result)
            } catch (e: Exception) {
                _weightsHistory.value = RepositoryResult.Error(e.localizedMessage)
            }
        }
    }

    fun navigateBack() {
        router.exit()
    }
}