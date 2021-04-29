package com.stock.sns.zuzuclub_android.ui.feedpost

import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.text.style.StyleSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.stock.sns.zuzuclub_android.BR
import com.stock.sns.zuzuclub_android.data.model.Comment
import com.stock.sns.zuzuclub_android.data.model.Feed
import com.stock.sns.zuzuclub_android.databinding.ItemCommentBinding
import com.stock.sns.zuzuclub_android.databinding.ItemFeedBinding
import com.stock.sns.zuzuclub_android.util.autolink.MODE_CUSTOM

class FeedPostRecyclerAdapter(
    var commentList: LiveData<ArrayList<Comment>>,
    var post: LiveData<Feed>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val TYPE_POST = 0
    val TYPE_COMMENT = 1

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) TYPE_POST else TYPE_COMMENT
        // return TYPE_COMMENT
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_POST) {
            val binding =
                ItemFeedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return PostHolder(binding)
        } else { // 댓글일때
            val binding =
                ItemCommentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return CommentHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is PostHolder -> {
                val item = post.value!!
                holder.bind(item)
            }
            is CommentHolder -> {
                val item = commentList.value!![position]
                holder.bind(item)
            }
        }
    }

    override fun getItemCount(): Int {
        Log.e("feedpost rcv adap", "${commentList.value!!.size}")
        return commentList.value!!.size
    }

    inner class PostHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var binding: ItemFeedBinding
        val custom = MODE_CUSTOM("(?:^|\\s|\$|[.])\\$[\\p{L}0-9_]*")

        constructor(binding: ItemFeedBinding) : this(binding.root) {
            this.binding = binding
            binding.iFeedIvProfile.apply {
                background = ShapeDrawable(OvalShape())
                clipToOutline = true
            }
            binding.iFeedTvText.apply {
                addAutoLinkMode(custom)
                onAutoLinkClick {
                    var clickedTag = it.originalText
                    if (clickedTag[0] == ' ') clickedTag = clickedTag.substring(1)
                    Log.e("feed adapter", "tag click$clickedTag")
                }
                customModeColor = Color.parseColor("#2d9cdb")
                addSpan(custom, StyleSpan(Typeface.BOLD))
            }
        }

        fun bind(feed: Feed) {
            binding.setVariable(BR.icFeed, feed)
        }
    }

    inner class CommentHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var binding: ItemCommentBinding

        constructor(binding: ItemCommentBinding) : this(binding.root) {
            this.binding = binding
            binding.iCommentIvProfile.apply {
                background = ShapeDrawable(OvalShape())
                clipToOutline = true
            }
        }

        fun bind(comment: Comment) {
            binding.setVariable(BR.icComment, comment)
        }
    }
}
