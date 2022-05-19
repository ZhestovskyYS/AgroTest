package com.example.agrotest.presentation.weights

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.agrotest.R
import com.example.agrotest.databinding.FragmentWeightsBinding
import com.example.core.di.ViewModelFactory
import com.example.core.ext.launchWhenCreated
import com.example.core.ext.shortToast
import com.example.entity.NetworkResult
import com.example.entity.WeightsData
import dagger.android.support.DaggerFragment
import javax.inject.Inject

private const val ERROR = "Error! Can't get weight data!"

class WeightsFragment : DaggerFragment(R.layout.fragment_weights) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by viewModels<WeightsViewModel> { viewModelFactory }
    private val binding by viewBinding(FragmentWeightsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindTabBar()
        observeWeightsData()
        viewModel.getWeightsData()
    }

    private fun observeWeightsData() {
        viewModel.weightsData.launchWhenCreated(lifecycleScope) {
            when (it) {
                is NetworkResult.Initial -> Unit
                is NetworkResult.Loading -> onLoading()
                is NetworkResult.Error -> onError(it.message)
                is NetworkResult.Success -> onSuccess(it.data)
            }
        }
    }

    private fun onLoading() {
        binding.apply {
            dataListLayout.isVisible = false
            weightsAnalyticsLayout.isVisible = false
            progressBar.isVisible = true
        }
    }

    private fun onError(message: String?) {
        shortToast(message ?: ERROR).show()
    }

    private fun onSuccess(data: WeightsData?) {
        if (data != null) {
            initLayouts(data)
            onNotLoading()
        } else {
            onError(ERROR)
        }
    }

    private fun initLayouts(data: WeightsData) {
        binding.locationValue.text = data.location
        binding.rfidValue.text = data.rfid
        binding.groupValue.text = data.group

        binding.currentWeight.text = data.currentWeight
        binding.previousWeight.text = data.previousWeight
        binding.nextWeight.text = data.nextWeight

        binding.historyButton.setOnClickListener {
            viewModel.navigateToWeightsHistory()
            shortToast("Переход к истории взвешиваний").show()
        }
    }

    private fun onNotLoading() {
        binding.apply {
            dataListLayout.isVisible = true
            weightsAnalyticsLayout.isVisible = true
            progressBar.isVisible = false
        }
    }

    private fun bindTabBar() {
        binding.tabbarView.apply {
            title.text = getString(R.string.weighting)
            backArrowLayout.apply {
                isVisible = true
                setOnClickListener {
                    viewModel.navigateBack()
                }
            }
        }
    }
}