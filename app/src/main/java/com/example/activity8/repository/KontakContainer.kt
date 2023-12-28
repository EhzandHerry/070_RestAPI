package com.example.activity8.repository

import com.example.activity8.model.Kontak
import com.example.activity8.network.KontakService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val kontakRepository: KontakRepository
}

class KontakContainer : AppContainer {
    private val baseUrl = "https://kancadonor.net//donotq/"
    private val json = Json { ignoreUnknownKeys = true }
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val kontakSerevice: KontakService by lazy {
        retrofit.create(KontakService::class.java)
    }
    override val kontakRepository: KontakRepository by lazy {
        NetworkKontakRepository(kontakSerevice)
    }
}