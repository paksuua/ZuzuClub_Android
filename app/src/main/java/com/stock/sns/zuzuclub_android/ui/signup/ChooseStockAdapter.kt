package com.stock.sns.zuzuclub_android.ui.signup

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stock.sns.zuzuclub_android.data.model.InterestData
import com.stock.sns.zuzuclub_android.databinding.ItemInterestStockBinding

class ChooseStockAdapter(private val stockList: ArrayList<InterestData>) : RecyclerView.Adapter<ChooseStockAdapter.ChooseStockViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChooseStockViewHolder {
        val binding = ItemInterestStockBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ChooseStockViewHolder(binding)
    }

    override fun getItemCount(): Int = stockList.size

    override fun onBindViewHolder(holder: ChooseStockViewHolder, position: Int) {
        val stock = stockList[position].name
        holder.bind(stock)
    }

    inner class ChooseStockViewHolder(binding: ItemInterestStockBinding) : RecyclerView.ViewHolder(binding.root) {
        private val stockName = binding.iInterestStockTvName
        fun bind(stock: String) {
            stockName.text = stock
        }
    }
}