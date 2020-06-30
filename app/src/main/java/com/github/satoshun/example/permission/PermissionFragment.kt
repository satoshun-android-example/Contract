package com.github.satoshun.example.permission

import android.Manifest
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.registerForActivityResult
import androidx.fragment.app.Fragment
import com.github.satoshun.example.R
import com.github.satoshun.example.databinding.PermissionFragBinding

class PermissionFragment : Fragment(R.layout.permission_frag) {
  private val binding: PermissionFragBinding get() = PermissionFragBinding.bind(requireView())

  private val requestLocation = registerForActivityResult(
    ActivityResultContracts.RequestPermission(),
    Manifest.permission.ACCESS_FINE_LOCATION
  ) { isGranted ->
    Toast.makeText(requireContext(), "isGranted $isGranted", Toast.LENGTH_SHORT).show()
  }

  private val requestPermissions = registerForActivityResult(
    ActivityResultContracts.RequestMultiplePermissions(),
    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.READ_EXTERNAL_STORAGE)
  ) { grants ->
    Toast.makeText(requireContext(), "grants $grants", Toast.LENGTH_SHORT).show()
  }


  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.fineLocation.setOnClickListener {
      requestLocation.launch(Unit)
    }

    binding.permissions.setOnClickListener {
      requestPermissions.launch(Unit)
    }
  }
}
