package com.cui.iss2021

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
  val MY_WRITE_EXTERNAL_REQUEST: Int = 1

  @RequiresApi(Build.VERSION_CODES.M)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    ex1.setOnClickListener {startActivity(Intent(this, Ex1Activity::class.java))}
    ex2.setOnClickListener {startActivity(Intent(this, Ex2Activity::class.java))}
    ex3.setOnClickListener {startActivity(Intent(this, Ex3Activity::class.java))}
    ex4.setOnClickListener {startActivity(Intent(this, Ex4Activity::class.java))}
    ex5.setOnClickListener {startActivity(Intent(this, Ex5Activity::class.java))}
    ex6.setOnClickListener {startActivity(Intent(this, Ex6Activity::class.java))}

    if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
      requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),MY_WRITE_EXTERNAL_REQUEST )
    }
  }
}
