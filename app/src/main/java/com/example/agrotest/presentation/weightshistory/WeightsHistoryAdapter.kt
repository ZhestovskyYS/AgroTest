package com.example.agrotest.presentation.weightshistory

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.agrotest.databinding.ItemTableRowHistoryBinding
import com.example.entity.WeightsToDate

class WeightsHistoryAdapter(
    private val items: List<WeightsToDate>
) : RecyclerView.Adapter<WeightsHistoryAdapter.ItemViewHolder>() {

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ItemViewHolder(
            ItemTableRowHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ItemViewHolder(
        private val binding: ItemTableRowHistoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: WeightsToDate) {
            binding.apply {
                dateValue.text = item.date
                weightValue.text = item.weight
            }
        }
    }
}