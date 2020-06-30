package com.github.satoshun.example.startactivityforresult

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.github.satoshun.example.R
import com.github.satoshun.example.databinding.StartActivityForResultFragBinding

class StartActivityForResultFragment : Fragment(R.layout.start_activity_for_result_frag) {
  private val binding: StartActivityForResultFragBinding
    get() = StartActivityForResultFragBinding.bind(requireView())

  private val startActivityLauncher = registerForActivityResult(
    ActivityResultContracts.StartActivityForResult()
  ) { result ->
    Toast.makeText(requireContext(), "result $result", Toast.LENGTH_SHORT).show()
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.startActivity.setOnClickListener {
      val intent = Intent(requireContext(), DummyActivity::class.java)
      startActivityLauncher.launch(intent)
    }
  }
}
