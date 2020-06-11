package com.github.satoshun.example

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.registerForActivityResult
import androidx.appcompat.app.AppCompatActivity

class AppActivity : AppCompatActivity(R.layout.app_act) {
  private val requestLocation = registerForActivityResult(
    ActivityResultContracts.RequestPermission(),
    ACCESS_FINE_LOCATION
  ) { isGranted ->
    Toast.makeText(this@AppActivity, "isGranted $isGranted", Toast.LENGTH_LONG).show()
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    requestLocation.launch(Unit)
  }
}
