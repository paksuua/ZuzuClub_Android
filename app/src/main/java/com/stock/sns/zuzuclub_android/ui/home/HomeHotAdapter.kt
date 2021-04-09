package com.stock.sns.zuzuclub_android.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.stock.sns.zuzuclub_android.BR
import com.stock.sns.zuzuclub_android.R
import com.stock.sns.zuzuclub_android.data.model.HotData
import com.stock.sns.zuzuclub_android.databinding.ItemMainHotBinding

class HomeHotAdapter(var itemlist: LiveData<ArrayList<HotData>>) : RecyclerView.Adapter<HomeHotAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemMainHotBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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
        lateinit var binding: ItemMainHotBinding

        constructor(binding: ItemMainHotBinding) : this(binding.root) {
            Log.d("ViewHolder", " create")
            this.binding = binding
        }

        fun bind(data: HotData) {
            binding.setVariable(BR.icHomeHot, data)

            when (data.emojiType) {
                1 -> binding.imgIcHot.setImageResource(R.drawable.flex_fox_96)
                2 -> binding.imgIcHot.setImageResource(R.drawable.sad_lion_96)
                3 -> binding.imgIcHot.setImageResource(R.drawable.expect_rabbit_96)
                else -> binding.imgIcHot.setImageResource(R.drawable.nervous_horse_96)
            }
        }
    }
}
