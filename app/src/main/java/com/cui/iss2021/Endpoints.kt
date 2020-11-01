package com.cui.iss2021

import com.cui.iss2021.model.InfoLight
import com.cui.iss2021.model.Sensor
import retrofit2.Call
import retrofit2.http.*

interface Endpoints{

  @GET("/sensors/2/get_temperature")
  fun getTemperature(): Call<Sensor>

  @Headers("Content-Type: application/json")
  @POST("/dimmers/set_level")
  fun setLight(@Body info: InfoLight): Call<InfoLight>

}
