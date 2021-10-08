package com.catnip.uiexambinarchapter5.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import com.bumptech.glide.Glide
import com.catnip.uiexambinarchapter5.R
import com.catnip.uiexambinarchapter5.databinding.ActivityDetailBinding
import com.catnip.uiexambinarchapter5.ui.data.ProfileData
import com.catnip.uiexambinarchapter5.ui.fragment.ProfileFragment

class DetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

    }

    private fun getIntentData() {
        val data = intent.getParcelableExtra<ProfileData>(KEY_DATA)

        binding.tvAddressProfile.text = data?.address
        binding.tvNameProfile.text = data?.name
        binding.tvProfessionProfile.text = data?.profession

        Glide.with(this)
            .load(data?.imageURL)
            .circleCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(binding.ivImageProfile)
    }

    companion object {

        const val KEY_DATA = "KEY_DATA"

        @JvmStatic
        fun startActivity(context : Context?, data : ProfileData) {

            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(KEY_DATA, data)
            context?.startActivity(intent)
        }

    }
}