package com.example.agrotest.presentation.weights

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.agrotest.R
import com.example.agrotest.databinding.FragmentWeightsBinding
import com.example.core.di.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class WeightsFragment : DaggerFragment(R.layout.fragment_weights) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by viewModels<WeightsViewModel> { viewModelFactory }
    private val binding by viewBinding(FragmentWeightsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.groupValue.text = "Русская бурая"
        binding.locationValue.text = "Стойло №7"
        binding.rfidValue.text = "123456789"
    }
}