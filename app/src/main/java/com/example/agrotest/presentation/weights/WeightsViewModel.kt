package com.example.agrotest.presentation.weights

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.agrotest.navigation.Screens
import com.example.entity.RepositoryResult
import com.example.entity.WeightsData
import com.example.usecase.GetWeightsDataUseCase
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.Screen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class WeightsViewModel @Inject constructor(
    private val router: Router,
    private val getWeightsDataUseCase: GetWeightsDataUseCase
) : ViewModel() {

    private val _weightsData = MutableStateFlow<RepositoryResult<WeightsData>>(RepositoryResult.Initial())
    val weightsData: StateFlow<RepositoryResult<WeightsData>> get() = _weightsData

    fun getWeightsData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _weightsData.value = RepositoryResult.Loading()
                val result = getWeightsDataUseCase()
                _weightsData.value = RepositoryResult.Success(result)
            } catch (e: Exception) {
                _weightsData.value = RepositoryResult.Error(e.localizedMessage)
            }
        }
    }

    fun navigateBack() {
        router.exit()
    }

    fun navigateToWeightsHistory(id: String) {
        router.navigateTo(Screens.weightsHistory(id))
    }
}