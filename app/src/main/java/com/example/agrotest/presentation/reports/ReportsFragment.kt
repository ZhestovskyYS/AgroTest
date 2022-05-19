package com.example.agrotest.presentation.reports

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.agrotest.R
import com.example.agrotest.databinding.FragmentReportsBinding
import com.example.core.di.ViewModelFactory
import com.example.core.ext.launchWhenCreated
import com.example.core.ext.shortToast
import com.example.entity.NetworkResult
import com.example.entity.TableRowData
import dagger.android.support.DaggerFragment
import javax.inject.Inject

private const val ERROR = "Error! Can't get data"

class ReportsFragment : DaggerFragment(R.layout.fragment_reports) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by viewModels<ReportsViewModel> { viewModelFactory }
    private val binding by viewBinding(FragmentReportsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindTabBar()
        observeTableData()
        viewModel.getTableData()
        binding.swipeRefreshLayout.setOnRefreshListener {
            onLoading()
            viewModel.getTableData()
        }
    }

    private fun bindTabBar() {
        binding.tabbarView.apply {
            title.text = getString(R.string.reports)
            backArrowLayout.apply {
                isVisible = true
                setOnClickListener {
                    viewModel.navigateBack()
                }
            }
        }
    }

    private fun observeTableData() {
        viewModel.tableData.launchWhenCreated(lifecycleScope) {
            when (it) {
                is NetworkResult.Initial -> Unit
                is NetworkResult.Loading -> onLoading()
                is NetworkResult.Error -> onError(it.message)
                is NetworkResult.Success -> onSuccess(it.data)
            }
        }
    }

    private fun onLoading() {
        binding.tableHeader.isVisible = false
        if (!binding.swipeRefreshLayout.isRefreshing) {
            binding.progressBar.isVisible = true
        }
    }

    private fun onNotLoading() {
        binding.tableHeader.isVisible = true
        if (!binding.swipeRefreshLayout.isRefreshing) {
            binding.progressBar.isVisible = false
        } else {
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }

    private fun onError(message: String?) {
        shortToast(message ?: ERROR).show()
    }

    private fun onSuccess(data: List<TableRowData>?) {
        if (data != null) {
            initAdapter(data)
        } else {
            onError(ERROR)
        }
    }

    private fun initAdapter(data: List<TableRowData>) {
        binding.recyclerViewGridRows.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ReportsAdapter(data) { rowData ->
                viewModel.navigateToDetailsGraphic(rowData)
                shortToast("Переход к графику").show()
            }
            onNotLoading()
        }
    }
}