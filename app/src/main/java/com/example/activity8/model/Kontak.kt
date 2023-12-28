package com.example.activity8.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Kontak(
    val id: Int,
    val name: String,
    val alamat: String,
    @SerialName(value = "telepon")
    val nohp: String,
)
