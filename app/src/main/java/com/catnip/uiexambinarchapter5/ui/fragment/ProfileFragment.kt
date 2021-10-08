package com.catnip.uiexambinarchapter5.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.catnip.uiexambinarchapter5.R
import com.catnip.uiexambinarchapter5.databinding.FragmentProfileBinding
import com.catnip.uiexambinarchapter5.ui.DetailActivity
import com.catnip.uiexambinarchapter5.ui.data.ProfileData

class ProfileFragment : Fragment() {

    private lateinit var binding : FragmentProfileBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(requireContext())
            .load(IMAGE_PROFILE_URL)
            .circleCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(binding.ivImageProfile)
        binding.tvNameProfile.text = getString(R.string.text_name_profile)
        binding.tvProfessionProfile.text = getString(R.string.text_profession_profile)

        navigateToDetail()
    }

    private fun navigateToDetail() {
        binding.clCardProfile.setOnClickListener {
            DetailActivity.startActivity(requireContext(), ProfileData(
                getString(R.string.text_name_profile),
                IMAGE_PROFILE_URL,
                getString(R.string.text_profession_profile),
                getString(R.string.text_address_profile)
            ))
        }
    }

    companion object {
        private const val IMAGE_PROFILE_URL = "https://avatars.githubusercontent.com/u/41815774?v=4"
    }


}