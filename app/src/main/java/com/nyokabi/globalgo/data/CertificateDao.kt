package com.nyokabi.globalgo.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.nyokabi.globalgo.model.Certificate


@Dao
interface CertificateDao {
    @Query("SELECT * FROM  certificates")
    fun getAllProducts(): LiveData<List<Certificate>>

    @Insert
    suspend fun insertProduct(certificate: Certificate)

    @Update
    suspend fun updateProduct(certificate: Certificate)

    @Delete
    suspend fun deleteProduct(certificate: Certificate)
}