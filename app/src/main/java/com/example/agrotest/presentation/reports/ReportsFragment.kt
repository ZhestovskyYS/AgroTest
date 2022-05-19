package com.example.agrotest.presentation.reports

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.agrotest.R
import com.example.agrotest.databinding.FragmentReportsBinding
import com.example.core.di.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class ReportsFragment : DaggerFragment(R.layout.fragment_reports) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by viewModels<ReportsViewModel> { viewModelFactory }
    private val binding by viewBinding(FragmentReportsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO: Собрать html, используя данные из репозитроия внутри viewModel, и передать готовый документ
        //binding.gridWebView.loadData()
    }
}