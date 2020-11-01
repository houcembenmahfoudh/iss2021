package com.cui.iss2021

import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cui.iss2021.model.InfoLight
import com.cui.iss2021.model.Sensor
import kotlinx.android.synthetic.main.activity_ex1.*
import kotlinx.android.synthetic.main.activity_ex2.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Ex2Activity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_ex2)

    seekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {

      override fun onProgressChanged(
        seekBar: SeekBar,
        progresValue: Int,
        fromUser: Boolean
      ) {
        setLight(progresValue)
      }

      override fun onStartTrackingTouch(seekBar: SeekBar) {}

      override fun onStopTrackingTouch(seekBar: SeekBar) {

      }
    })
  }

  private fun setLight(value: Int) {
    val request = ServiceBuilder.buildService(Endpoints::class.java)
    val call = request.setLight(InfoLight("3",value))
    call.enqueue(object : Callback<InfoLight> {
      override fun onResponse(call: Call<InfoLight>, response: Response<InfoLight>) {
        if (response.isSuccessful) {
          Log.d("EX2", response.body().toString())
        }
      }

      override fun onFailure(call: Call<InfoLight>, t: Throwable) {
        Toast.makeText(this@Ex2Activity, "${t.message}", Toast.LENGTH_SHORT).show()
      }
    })
  }
}
