package com.nyokabi.globalgo.ui.screens.splash

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import com.nyokabi.globalgo.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.nyokabi.globalgo.navigation.ROUT_LOGIN
import com.nyokabi.globalgo.navigation.ROUT_START
import com.nyokabi.globalgo.ui.theme.bluey
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun  SplashScreen(navController: NavController){

    Column(
        modifier = Modifier.fillMaxSize().background(bluey),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center


    ){



        //navigation

        val coroutine = rememberCoroutineScope()
        coroutine.launch {
            delay(2000)
            navController.navigate(ROUT_START)

        }

        //end of navigation


        // Row starts
        Row (){
            Image(
                painter = painterResource(R.drawable.img_5),
                contentDescription = "home",
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .clip(shape = RoundedCornerShape(10.dp)),
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.width(20.dp))


            Column {
                Text(
                    text = "GlobalGo",
                    fontSize = 50.sp,
                    fontWeight = FontWeight.ExtraBold,
                    fontStyle = FontStyle.Italic

                )




                Spacer(modifier = Modifier.width(20.dp))

            }

        }
    }
    //end of row






    }





@Preview(showBackground = true)
@Composable
fun  SplashScreenPreview(){
    SplashScreen(rememberNavController())
}