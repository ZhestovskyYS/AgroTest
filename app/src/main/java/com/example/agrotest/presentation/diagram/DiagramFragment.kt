package com.example.agrotest.presentation.diagram

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.agrotest.R
import com.example.agrotest.databinding.FragmentDiagramBinding
import com.example.core.di.ViewModelFactory
import com.example.core.ext.launchWhenCreated
import dagger.android.support.DaggerFragment
import javax.inject.Inject

private const val ANIMAL = "animal"
private const val ANIMALS_COUNT = "animals_count"

class DiagramFragment : DaggerFragment(R.layout.fragment_diagram) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by viewModels<DiagramViewModel> { viewModelFactory }
    private val binding by viewBinding(FragmentDiagramBinding::bind)

    private val animalsIds: List<String>
        get() {
            val idList = mutableListOf<String>()
            arguments?.getInt(ANIMALS_COUNT)?.let { count ->
                for (index in 0 until count) {
                    arguments?.getString(ANIMAL + index)?.let { id ->
                        idList.add(id)
                    }
                }
            }
            return idList
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeDiagramData()
        viewModel.getDiagramData(animalsIds)
    }

    private fun observeDiagramData() {
        viewModel.diagramData.launchWhenCreated(lifecycleScope) {
            when (it) {

            }
        }
    }

    companion object {
        fun newInstance(animals_ids: List<String>) =
            DiagramFragment().also {
                it.arguments = Bundle().apply {
                    putInt(ANIMALS_COUNT, animals_ids.size)
                    animals_ids.forEachIndexed { index, id ->
                        putString(ANIMAL + index, id)
                    }
                }
            }
    }
}