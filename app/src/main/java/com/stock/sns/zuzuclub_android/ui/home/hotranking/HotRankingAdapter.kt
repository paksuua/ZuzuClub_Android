package com.stock.sns.zuzuclub_android.ui.home.hotranking

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.stock.sns.zuzuclub_android.BR
import com.stock.sns.zuzuclub_android.data.model.HotRankingData
import com.stock.sns.zuzuclub_android.databinding.ItemHotRankingBinding

class HotRankingAdapter(var itemlist: LiveData<ArrayList<HotRankingData>>) :
    RecyclerView.Adapter<HotRankingAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemHotRankingBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = itemlist.value!![position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemlist.value!!.size
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var binding: ItemHotRankingBinding

        constructor(binding: ItemHotRankingBinding) : this(binding.root) {
            Log.d("hot rank ViewHolder", " create")
            this.binding = binding
        }

        fun bind(data: HotRankingData) {
            binding.setVariable(BR.icHotRanking, data)

            // binding.tvHotRank.text = data.ranking.toString() + "위"
        }
    }
}
