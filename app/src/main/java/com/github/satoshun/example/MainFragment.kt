package com.github.satoshun.example

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.github.satoshun.example.databinding.MainFragBinding

class MainFragment : Fragment(R.layout.main_frag) {
  private val binding: MainFragBinding get() = MainFragBinding.bind(requireView())

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.permission.setOnClickListener {
      findNavController().navigate(MainFragmentDirections.navMainToPermission())
    }

    binding.startActivity.setOnClickListener {
      findNavController().navigate(MainFragmentDirections.navMainToStartActivityForResult())
    }

    binding.getContent.setOnClickListener {
      findNavController().navigate(MainFragmentDirections.navMainToGetContent())
    }
  }
}
