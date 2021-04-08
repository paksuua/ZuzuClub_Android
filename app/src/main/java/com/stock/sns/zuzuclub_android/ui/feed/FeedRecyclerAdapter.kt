package com.stock.sns.zuzuclub_android.ui.feed

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.text.style.StyleSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.stock.sns.zuzuclub_android.BR
import com.stock.sns.zuzuclub_android.R
import com.stock.sns.zuzuclub_android.data.model.Feed
import com.stock.sns.zuzuclub_android.databinding.ItemFeedBinding
import com.volokh.danylo.hashtaghelper.HashTagHelper
import io.github.armcha.autolink.MODE_CUSTOM
import io.github.armcha.autolink.MODE_HASHTAG

class FeedRecyclerAdapter(var itemlist: LiveData<ArrayList<Feed>>): RecyclerView.Adapter<FeedRecyclerAdapter.Holder>() {
    //lateinit var itemlist : ArrayList<Feed>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemFeedBinding.inflate(LayoutInflater.from(parent.context), parent, false)

//        val hashtagSimbol = '\$'
//        var mTextHashTagHelper: HashTagHelper = HashTagHelper.Creator.create(
//            Color.parseColor("#2d9cdb"),
//            HashTagHelper.OnHashTagClickListener { Toast.makeText(parent.context, "click", Toast.LENGTH_LONG)
//            },
//            hashtagSimbol
//        )
//
//        mTextHashTagHelper.handle(binding.iFeedTvText)

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
        val custom = MODE_CUSTOM("(?:^|\\s|\$|[.])\\$[\\p{L}0-9_]*")

        constructor(binding: ItemFeedBinding) : this(binding.root) {
            Log.d("ViewHolder", " create")
            this.binding = binding
            binding.iFeedIvProfile.apply {
                background = ShapeDrawable(OvalShape())
                clipToOutline = true
            }
            binding.iFeedTvText.apply {
                addAutoLinkMode(custom)
                onAutoLinkClick { Log.e("feed adapter","tag click") }
                customModeColor = Color.parseColor("#2d9cdb")
                addSpan(custom, StyleSpan(Typeface.BOLD))
            }

        }

        fun bind(feed: Feed) {
            binding.setVariable(BR.icFeed, feed)
        }

    }
}
