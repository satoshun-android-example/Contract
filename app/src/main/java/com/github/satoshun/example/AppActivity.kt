package com.github.satoshun.example

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.Manifest.permission.READ_EXTERNAL_STORAGE
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

  private val requestPermissions = registerForActivityResult(
    ActivityResultContracts.RequestMultiplePermissions(),
    arrayOf(ACCESS_FINE_LOCATION, READ_EXTERNAL_STORAGE)
  ) { grants ->
    Toast.makeText(this@AppActivity, "grants $grants", Toast.LENGTH_LONG).show()
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

//    requestLocation.launch(Unit)
    requestPermissions.launch(Unit)
  }
}
