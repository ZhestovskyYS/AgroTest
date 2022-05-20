package com.example.agrotest.presentation.settings

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.agrotest.R
import com.example.agrotest.databinding.FragmentSettingsBinding
import com.example.core.di.ViewModelFactory
import com.example.core.ext.shortToast
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class SettingsFragment : DaggerFragment(R.layout.fragment_settings) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by viewModels<SettingsViewModel> { viewModelFactory }
    private val binding by viewBinding(FragmentSettingsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindTabBar()
        bindButtons()
    }

    private fun bindButtons() {
        binding.apply {
            bluetoothButton.setOnClickListener {
                shortToast("Настройки Bluetooth").show()
            }
            wifiButton.setOnClickListener {
                shortToast("Настройки Wi-Fi").show()
            }
            powerButton.setOnClickListener {
                shortToast("Параметры Питания").show()
            }
            dateButton.setOnClickListener {
                shortToast("Настройки Даты и Времени").show()
            }
        }
    }

    private fun bindTabBar() {
        binding.tabbarView.apply {
            title.text = getString(R.string.settings)
            backArrowLayout.isVisible = true
            backArrowLayout.setOnClickListener {
                viewModel.navigateBack()
            }
        }
    }
}