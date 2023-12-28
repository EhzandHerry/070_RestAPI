package com.example.activity8.repository

import com.example.activity8.model.Kontak
import com.example.activity8.network.KontakService
import java.io.IOException

interface KontakRepository {
    suspend fun getKontak(): List<Kontak>
    suspend fun deleteKontak(id: Int)
}

class NetworkKontakRepository(
    private val kontakApiService: KontakService
) : KontakRepository{
    override suspend fun getKontak(): List<Kontak> = kontakApiService.getKontak()

    override suspend fun deleteKontak(id: Int){
        try {
            val response = kontakApiService.deleteKontak(id)
            if (!response.isSuccessful){
                throw IOException("Failed to delete kontak. Http status code: ${response.code()}")
            }
            else{
                response.message()
            }
        } catch (e: Exception){
            throw e
        }
    }

}