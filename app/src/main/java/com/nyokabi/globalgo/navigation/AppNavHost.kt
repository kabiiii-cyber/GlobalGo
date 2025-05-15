package com.nyokabi.globalgo.navigation

import StudentScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nyokabi.globalgo.data.UserDatabase
import com.nyokabi.globalgo.repository.UserRepository
import com.nyokabi.globalgo.ui.screens.about.AboutScreen

import com.nyokabi.globalgo.ui.screens.auth.LoginScreen
import com.nyokabi.globalgo.ui.screens.auth.RegisterScreen
import com.nyokabi.globalgo.ui.screens.home.HomeScreen
import com.nyokabi.globalgo.ui.screens.school.SchoolScreen
import com.nyokabi.globalgo.ui.screens.splash.SplashScreen
import com.nyokabi.globalgo.viewmodel.AuthViewModel
import com.nyokabi.harakamall.ui.screens.start.StartScreen


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_SPLASH,

) {


    val context = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(ROUT_HOME) {
            HomeScreen(navController)
        }
        composable(ROUT_ABOUT) {
            AboutScreen(navController)
        }
        composable(ROUT_SPLASH) {
            SplashScreen(navController)
        }
        composable(ROUT_START) {
            StartScreen(navController)
        }

        composable(ROUT_SCHOOL) {
           SchoolScreen(navController)
        }

        composable(ROUT_STUDENT) {
            val context = LocalContext.current
            StudentScreen(navController, context)
        }






        //AUTHENTICATION

        // Initialize Room Database and Repository for Authentication
        val appDatabase = UserDatabase.getDatabase(context)
        val authRepository = UserRepository(appDatabase.userDao())
        val authViewModel: AuthViewModel = AuthViewModel(authRepository)
        composable(ROUT_REGISTER) {
            RegisterScreen(authViewModel, navController) {
                navController.navigate(ROUT_LOGIN) {
                    popUpTo(ROUT_REGISTER) { inclusive = true }
                }
            }
        }

        composable(ROUT_LOGIN) {
            LoginScreen(authViewModel, navController) {
                navController.navigate(ROUT_HOME) {
                    popUpTo(ROUT_LOGIN) { inclusive = true }
                }
            }
        }









    }




}



@Composable
fun AuthViewModel(x0: UserRepository) {
    TODO("Not yet implemented")
}



