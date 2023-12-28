package com.example.activity8.network

import com.example.activity8.model.Kontak
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface KontakService {
    @Headers(
        "Accept: application/json"
    )
    @GET("siswa.json")
    suspend fun getKontak(): List<Kontak>
    @DELETE("kontak/{id}")
    suspend fun deleteKontak(@Path("id") id : Int): Response<Void>
}