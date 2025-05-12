package com.nyokabi.globalgo.model
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "certificates")
data class Certificate(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val certificatetype: String,
    val year: Double,
    val imagePath: String

    )