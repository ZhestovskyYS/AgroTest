package com.example.agrotest.presentation.reports

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.agrotest.databinding.ItemTableRowBinding
import com.example.entity.TableRowData

class ReportsAdapter(
    private val items: List<TableRowData>,
    private val goToGraphic: (TableRowData) -> Unit
) : RecyclerView.Adapter<ReportsAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ItemViewHolder(
            ItemTableRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ReportsAdapter.ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    inner class ItemViewHolder(
        private val binding: ItemTableRowBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: TableRowData) {
            binding.apply {
                animal.text = data.animal
                currentWeight.text = data.currentWeight
                previousWeight.text = data.previousWeight
                deltaWeight.text = data.deltaWeight

                root.setOnClickListener {
                    goToGraphic(data)
                }
            }
        }
    }
}