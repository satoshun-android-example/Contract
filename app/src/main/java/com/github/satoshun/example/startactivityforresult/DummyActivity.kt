package com.github.satoshun.example.startactivityforresult

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DummyActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    lifecycleScope.launch {
      delay(3000)
      val value = Intent().apply {
        putExtra("test", "hoge")
      }
      setResult(Activity.RESULT_OK, value)
      finish()
    }
  }
}
