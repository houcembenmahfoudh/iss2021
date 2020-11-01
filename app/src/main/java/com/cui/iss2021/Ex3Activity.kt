package com.cui.iss2021

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.io.FileOutputStream
import java.util.*

class Ex3Activity : AppCompatActivity() {

  @RequiresApi(Build.VERSION_CODES.M)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_ex3)

    val timer = Timer()
    var i = 0;
    timer.scheduleAtFixedRate(
      object : TimerTask() {
        override fun run() {
          i++;
          if (i == 5)
            timer.cancel();
          writeToFile("xxxx" + i + "\n");
        }
      },0, 2000) // 2seconds
  }

  private fun writeToFile(data: String) {
    val fileName = "/storage/emulated/0/Download/test.txt"; // file path
    FileOutputStream(fileName, true).use { output -> output.write(data.toByteArray()) } // append true
  }

}
