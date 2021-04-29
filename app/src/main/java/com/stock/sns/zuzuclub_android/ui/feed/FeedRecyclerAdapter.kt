package com.stock.sns.zuzuclub_android.ui.feed

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.text.style.StyleSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.stock.sns.zuzuclub_android.BR
import com.stock.sns.zuzuclub_android.R
import com.stock.sns.zuzuclub_android.data.model.Feed
import com.stock.sns.zuzuclub_android.databinding.ItemFeedBinding
import com.stock.sns.zuzuclub_android.ui.feedpost.FeedPostActivity
import com.stock.sns.zuzuclub_android.util.autolink.MODE_CUSTOM
import com.stock.sns.zuzuclub_android.util.autolink.MODE_MENTION

class FeedRecyclerAdapter(var itemlist: LiveData<ArrayList<Feed>>) :
    RecyclerView.Adapter<FeedRecyclerAdapter.Holder>() {
    // lateinit var itemlist : ArrayList<Feed>

    // 지금 닉네임 저장할거임 --> 이거 전역으로 만들어야할거같은데 유저정보(데모는 임시)
    var demoNickname = "쌍문동 불주먹"

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
        val custom = MODE_CUSTOM("(?:^|\\s|\$|[.])\\$[\\p{L}0-9_]*")

        constructor(binding: ItemFeedBinding) : this(binding.root) {
            Log.d("ViewHolder", " create")
            this.binding = binding
            binding.iFeedIvProfile.apply {
                background = ShapeDrawable(OvalShape())
                clipToOutline = true
            }
            binding.iFeedBaseLayout.setOnClickListener {
                Log.e("feed adapter", "item click")
                val intent = Intent(it.context, FeedPostActivity::class.java)
                it.context.startActivity(intent)
            }
            binding.iFeedTvText.apply {
                addAutoLinkMode(custom, MODE_MENTION) // 멘션모드가 더보기임
                onAutoLinkClick {
                    if (it.originalText == " ...더 보기") {
                        Log.e("feed adapter", "더보기눌렀다~~~~~~")
                    } else {
                        var clickedTag = it.originalText
                        if (clickedTag[0] == ' ') clickedTag = clickedTag.substring(1)
                        Log.e("feed adapter", "tag click$clickedTag")
                    }
                }
                customModeColor = Color.parseColor("#2d9cdb")
                mentionModeColor = ContextCompat.getColor(this.context, R.color.zuzu_black_100)
                addSpan(custom, StyleSpan(Typeface.BOLD))
                addSpan(MODE_MENTION, StyleSpan(Typeface.BOLD))
            }

            binding.iFeedIvMore.setOnClickListener {
                var popupMenu = PopupMenu(itemView.context, binding.iFeedIvMore)
                if (binding.iFeedTvNickname.text == demoNickname) popupMenu.inflate(R.menu.feedlist_my_menu)
                else popupMenu.inflate(R.menu.feedlist_other_menu)
                popupMenu.setOnMenuItemClickListener {
                    when (it.itemId) {
                        R.id.menu_feedlist_block -> {
                            Log.e("feed viewmodel", "block click")
                        }
                        R.id.menu_feedlist_follow -> {
                            Log.e("feed viewmodel", "follow click")
                        }
                        R.id.menu_feedlist_delete -> {
                            Log.e("feed viewmodel", "delete click")
                        }
                        R.id.menu_feedlist_modify -> {
                            Log.e("feed viewmodel", "modify click")
                        }
                    }

                    return@setOnMenuItemClickListener false
                }
                popupMenu.show()
            }
        }

        fun bind(feed: Feed) {
            binding.setVariable(BR.icFeed, feed)
        }
    }
}
