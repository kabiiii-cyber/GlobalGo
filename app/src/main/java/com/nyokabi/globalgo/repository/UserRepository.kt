package com.nyokabi.globalgo.repository

import com.nyokabi.globalgo.data.UserDao
import com.nyokabi.globalgo.model.User

class UserRepository(private val userDao: UserDao) {
    suspend fun registerUser(user: User) {
        userDao.registerUser(user)
    }

    suspend fun loginUser(email: String, password: String): User? {
        return userDao.loginUser(email, password)
    }
}