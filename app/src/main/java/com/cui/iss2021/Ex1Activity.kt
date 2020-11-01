package com.cui.iss2021

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cui.iss2021.model.Sensor
import kotlinx.android.synthetic.main.activity_ex1.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class Ex1Activity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_ex1)
    getTemperature()
     }

  private fun getTemperature() {
    val request = ServiceBuilder.buildService(Endpoints::class.java)
    val call = request.getTemperature()
    call.enqueue(object : Callback<Sensor> {
      override fun onResponse(call: Call<Sensor>, response: Response<Sensor>) {
        if (response.isSuccessful) {
          value.text = response.body()?.value.toString();
          time.text = getDate(response.body()!!.updateTime)
        }
      }

      override fun onFailure(call: Call<Sensor>, t: Throwable) {
        Toast.makeText(this@Ex1Activity, "${t.message}", Toast.LENGTH_SHORT).show()
      }
    })
  }

  private fun getDate(timeStamp: Long): String? {
    val sdf = SimpleDateFormat("dd/MM/yyyy hh:mm:ss", Locale.FRANCE)
    val netDate = Date(timeStamp*1000)
    return sdf.format(netDate)
  }
}
