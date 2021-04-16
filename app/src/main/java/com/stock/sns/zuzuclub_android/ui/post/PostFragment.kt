package com.stock.sns.zuzuclub_android.ui.post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.stock.sns.zuzuclub_android.R
import com.stock.sns.zuzuclub_android.data.model.EmojiPackData
import com.stock.sns.zuzuclub_android.databinding.FragmentPostBinding

class PostFragment : Fragment() {
    private val viewModel by viewModels<PostViewModel>()
    private val binding by lazy { FragmentPostBinding.inflate(layoutInflater) }

    var emojiPackData = MutableLiveData<ArrayList<EmojiPackData>>()
    private lateinit var emojiPackAdapter: PostEmojiPackAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initUI()
        return binding.root
    }

    private fun initUI() {
        // 이모티콘 패키지
        binding.rvPostEmojipack.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        viewModel.emojiPackData.observe(
            viewLifecycleOwner,
            {
                emojiPackData.value = it
                emojiPackAdapter = PostEmojiPackAdapter(emojiPackData)
                binding.rvPostEmojipack.adapter = emojiPackAdapter
                emojiPackAdapter.notifyDataSetChanged()
            }
        )

        // 패키지별 이모티콘
        binding.rvPostEmojis.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        binding.edtPost.doOnTextChanged { text1, start, count, after ->
            binding.ctvPostConfirm.isChecked = !text1.isNullOrBlank()
        }

        // 취소 or 완료
        binding.tvPostBack.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_to_navigation_home)
        }

        binding.ctvPostConfirm.setOnClickListener { view->
            view.findNavController().navigate(R.id.action_to_navigation_home)
        }
    }
}
