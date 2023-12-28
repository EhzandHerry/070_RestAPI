package com.example.activity8.repository

import com.example.activity8.model.Kontak
import com.example.activity8.network.KontakService
import java.io.IOException

interface KontakRepository {
    suspend fun getKontak(): List<Kontak>
}

class NetworkKontakRepository(
    private val kontakApiService: KontakService
) : KontakRepository{
    override suspend fun getKontak(): List<Kontak> = kontakApiService.getKontak()

}