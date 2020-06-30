package com.github.satoshun.example.getcontent

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.github.satoshun.example.R
import com.github.satoshun.example.databinding.GetContentFragBinding

class GetContentFragment : Fragment(R.layout.get_content_frag) {
  private val binding: GetContentFragBinding
    get() = GetContentFragBinding.bind(requireView())

  private val getContent = registerForActivityResult(
    ActivityResultContracts.GetContent()
  ) { uri ->
    Toast.makeText(requireContext(), "uri $uri", Toast.LENGTH_SHORT).show()
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.image.setOnClickListener {
      getContent.launch("image/*")
    }
  }
}
