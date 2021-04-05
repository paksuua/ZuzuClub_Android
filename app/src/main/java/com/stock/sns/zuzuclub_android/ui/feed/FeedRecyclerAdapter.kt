package com.stock.sns.zuzuclub_android.ui.feed

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.stock.sns.zuzuclub_android.BR
import com.stock.sns.zuzuclub_android.data.model.Feed
import com.stock.sns.zuzuclub_android.databinding.ItemFeedBinding

class FeedRecyclerAdapter(var itemlist: LiveData<ArrayList<Feed>>): RecyclerView.Adapter<FeedRecyclerAdapter.Holder>() {
    //lateinit var itemlist : ArrayList<Feed>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemFeedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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
        lateinit var binding: ItemFeedBinding

        constructor(binding: ItemFeedBinding) : this(binding.root) {
            Log.d("ViewHolder", " create")
            this.binding = binding
        }

        fun bind(feed: Feed) {
            binding.setVariable(BR.icFeed, feed)
        }

    }
}
