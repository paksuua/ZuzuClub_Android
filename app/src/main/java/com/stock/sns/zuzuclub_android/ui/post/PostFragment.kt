package com.stock.sns.zuzuclub_android.ui.post

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.stock.sns.zuzuclub_android.R
import com.stock.sns.zuzuclub_android.data.model.EmojiPackData
import com.stock.sns.zuzuclub_android.databinding.FragmentPostBinding
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import timber.log.Timber
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.InputStream

class PostFragment : Fragment() {
    private val viewModel by viewModels<PostViewModel>()
    private val binding by lazy { FragmentPostBinding.inflate(layoutInflater) }

    var emojiPackData = MutableLiveData<ArrayList<EmojiPackData>>()
    private lateinit var emojiPackAdapter: PostEmojiPackAdapter
    private var isProfileImageFilled = false
    private lateinit var selectPicUri: Uri
    private var isImageChanged = false

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
        // 취소 or 완료
        binding.tvPostBack.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_to_navigation_home)
        }

        binding.ctvPostConfirm.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_to_navigation_home)
        }

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

        // 미리보기 이미지 삭제
        binding.imgPostDeletePreview.setOnClickListener {
            binding.cstPostPreview.visibility = View.GONE
        }

        // 이미지 가져오기
        // TODO: 3rd part 라이브러리 없이 4:3 crop 적용하기
        binding.imgPostGallery.setOnClickListener {
            if (!checkPermission(CHECK_PERMISSION_READ)) {
                reqPermission(CHECK_PERMISSION_READ)
            } else {
                getImageFromAlbum()
                isImageChanged = true
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            IMAGE_PICK_CODE -> {
                when (resultCode) {
                    Activity.RESULT_OK -> {
                        binding.cstPostPreview.visibility = View.VISIBLE
                        Timber.d("Success Get Image from Gallery")
                        // 정상적으로 이미지를 가져온 경우
                        selectPicUri = data?.data!!
                        Glide.with(this).load(selectPicUri)
                            .override(80, 60)
                            .centerCrop()
                            .into(binding.imgPostPreview)

                        isProfileImageFilled = true
                    }
                    else -> {
                        Timber.d("Fail Get Image From Gallery")
                        binding.cstPostPreview.visibility = View.GONE
                        isProfileImageFilled = false
                    }
                }
            }
        }
    }

    private fun getImageFromAlbum() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(
            intent,
            IMAGE_PICK_CODE
        )
    }

    private fun checkPermission(checkWhich: Int): Boolean {
        var result = false
        when (checkWhich) {
            CHECK_PERMISSION_READ ->
                result = ActivityCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_GRANTED
        }
        return result
    }

    private fun reqPermission(whichPermission: Int) {
        when (whichPermission) {
            CHECK_PERMISSION_READ -> {
                if (ActivityCompat.shouldShowRequestPermissionRationale(
                        requireActivity(),
                        Manifest.permission.READ_EXTERNAL_STORAGE
                    )
                ) {
                    Toast.makeText(context, "권한이 거부되었습니다. 직접 권한을 허용해야 합니다.", Toast.LENGTH_SHORT).show()
                } else {
                    requestPermissions(
                        arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                        PERMISSION_CALLBACK_CONSTANT
                    )
                }
            }
        }
    }

    private fun uploadProfile(selectPicUri: Uri) {
        val options = BitmapFactory.Options()
        val inputStream: InputStream = activity?.contentResolver?.openInputStream(selectPicUri)!!
        val bitmap = BitmapFactory.decodeStream(inputStream, null, options)
        val byteArrayOutputStream = ByteArrayOutputStream()
        bitmap?.compress(Bitmap.CompressFormat.JPEG, 20, byteArrayOutputStream)

        val photoBody = RequestBody.create(
            MediaType.parse("image/*"),
            byteArrayOutputStream.toByteArray()
        )

        val pictureRb = MultipartBody.Part.createFormData(
            "profile",
            File(selectPicUri.toString()).name,
            photoBody
        )

        // viewModel.editProfile(pictureRb)
    }

    companion object {
        private const val IMAGE_PICK_CODE = 1000
        private const val PERMISSION_CALLBACK_CONSTANT = 100
        private const val CHECK_PERMISSION_READ = 102
    }
}
