package com.example.agrotest.presentation.weightshistory

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.agrotest.R
import com.example.agrotest.databinding.FragmentWeightsHistoryBinding
import com.example.core.di.ViewModelFactory
import com.example.core.ext.launchWhenCreated
import com.example.core.ext.shortToast
import com.example.entity.RepositoryResult
import com.example.entity.WeightsHistory
import com.example.entity.WeightsToDate
import dagger.android.support.DaggerFragment
import javax.inject.Inject

private const val ID = "id"
private const val ERROR = "Error! Can't get weights history"

class WeightsHistoryFragment : DaggerFragment(R.layout.fragment_weights_history) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by viewModels<WeightsHistoryViewModel> { viewModelFactory }
    private val binding by viewBinding(FragmentWeightsHistoryBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindTabBar()
        observeWeightsHistory()
        tryToGetAnimalWeightsHistory()
    }

    private fun observeWeightsHistory() {
        viewModel.weightsHistory.launchWhenCreated(lifecycleScope) {
            when (it) {
                is RepositoryResult.Initial -> Unit
                is RepositoryResult.Loading -> onLoading()
                is RepositoryResult.Error -> onError(it.message)
                is RepositoryResult.Success -> onSuccess(it.data)
            }
        }
    }

    private fun onSuccess(data: WeightsHistory?) {
        if (data != null) {
            binding.animalName.text = data.animalName
            initAdapter(data.weightsList)
            onNotLoading()
        } else {
            onError(ERROR)
        }
    }

    private fun initAdapter(weightsList: List<WeightsToDate>) {
        binding.tableCollsRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = WeightsHistoryAdapter(weightsList)
        }
    }

    private fun onLoading() {
        binding.tableHeader.isVisible = false
        binding.progressBar.isVisible = true
    }

    private fun onNotLoading() {
        binding.tableHeader.isVisible = true
        binding.progressBar.isVisible = false
    }

    private fun tryToGetAnimalWeightsHistory() {
        val id = arguments?.getString(ID)
        if (id != null) {
            viewModel.getAnimalWeightsHistory(id)
        } else {
            onError(ERROR)
        }
    }

    private fun onError(message: String?) {
        shortToast(message ?: ERROR).show()
    }

    private fun bindTabBar() {
        binding.tabbarView.apply {
            title.text = getString(R.string.weights_history)
            backArrowLayout.isVisible = true
            backArrowLayout.setOnClickListener {
                viewModel.navigateBack()
            }
        }
    }

    companion object {
        fun newInstance(id: String) = WeightsHistoryFragment().also {
            it.arguments = Bundle().apply {
                putString(ID, id)
            }
        }
    }
}