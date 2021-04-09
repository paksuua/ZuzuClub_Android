package com.stock.sns.zuzuclub_android.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.stock.sns.zuzuclub_android.BR
import com.stock.sns.zuzuclub_android.R
import com.stock.sns.zuzuclub_android.data.model.InterestData
import com.stock.sns.zuzuclub_android.databinding.ItemMainInterestBinding

class HomeInterestAdapter(var itemlist: LiveData<ArrayList<InterestData>>) : RecyclerView.Adapter<HomeInterestAdapter.Holder>() {
    // lateinit var itemlist : ArrayList<Feed>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemMainInterestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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
        lateinit var binding: ItemMainInterestBinding

        constructor(binding: ItemMainInterestBinding) : this(binding.root) {
            Log.d("ViewHolder", " create")
            this.binding = binding
//            binding..apply {
//                background = ShapeDrawable(OvalShape())
//                clipToOutline = true
//            }
        }

        fun bind(data: InterestData) {
            binding.setVariable(BR.icHomeInterest, data)

            when (data.emojiType) {
                1 -> binding.imgIcInterest.setImageResource(R.drawable.flex_fox_40)
                2 -> binding.imgIcInterest.setImageResource(R.drawable.sad_lion_40)
                3 -> binding.imgIcInterest.setImageResource(R.drawable.expect_rabbit_40)
                else -> binding.imgIcInterest.setImageResource(R.drawable.nervous_horse_40)
            }
        }
    }
}
