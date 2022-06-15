package com.itcube.ymap


import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface APIService {

//Получение
@GET("/api/v1/employees")
suspend fun getEmployees(): Response<ResponseBody>



}