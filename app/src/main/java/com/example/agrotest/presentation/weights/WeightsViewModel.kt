package com.example.agrotest.presentation.weights

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.entity.NetworkResult
import com.example.entity.WeightsData
import com.example.usecase.GetTableDataUseCase
import com.example.usecase.GetWeightsDataUseCase
import com.github.terrakok.cicerone.Router
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

    private val _weightsData = MutableStateFlow<NetworkResult<WeightsData>>(NetworkResult.Initial())
    val weightsData: StateFlow<NetworkResult<WeightsData>> get() = _weightsData

    fun getWeightsData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _weightsData.value = NetworkResult.Loading()
                val result = getWeightsDataUseCase()
                _weightsData.value = NetworkResult.Success(result)
            } catch (e: Exception) {
                _weightsData.value = NetworkResult.Error(e.localizedMessage)
            }
        }
    }

    fun navigateBack() {
        router.exit()
    }

    fun navigateToWeightsHistory() {
        //TODO("Not yet implemented")
    }
}