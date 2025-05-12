package com.nyokabi.globalgo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nyokabi.globalgo.model.Certificate
import com.nyokabi.globalgo.model.User

import kotlin.jvm.java

@Database(entities = [Certificate::class, User::class], version = 3, exportSchema = false)
abstract class CertificateDatabase : RoomDatabase() {
    abstract fun certificateDao(): CertificateDao
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE:CertificateDatabase? = null

        fun getDatabase(context: Context): CertificateDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CertificateDatabase::class.java,
                    "main_database"
                )
                    .fallbackToDestructiveMigration() // 💥 This clears DB on version change
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}