package com.example.activity8.repository

import com.example.activity8.model.Kontak
import com.example.activity8.network.KontakService
import java.io.IOException

interface KontakRepository {
    suspend fun getKontak(): List<Kontak>

    suspend fun insertKontak(kontak: Kontak)

    suspend fun updateKontak(id: Int, kontak: Kontak)

    suspend fun deleteKontak(id: Int)

    suspend fun getkontakById(id: Int): Kontak
}

class NetworkKontakRepository(
    private val kontakApiService: KontakService
) : KontakRepository{
    /* Fetches List of Kontak from kontakAPI*/
    override suspend fun getKontak(): List<Kontak> = kontakApiService.getKontak()

    //insert kontak
    override suspend fun insertKontak(kontak: Kontak){
        kontakApiService.insertKontak(kontak)
    }

    //update kontak
    override suspend fun updateKontak(id: Int, kontak: Kontak){
        kontakApiService.updateKontak(id,kontak)
    }

    //delete kontak
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

    override suspend fun getkontakById(id:Int): Kontak{
        TODO("Not yet implemented")
    }
}