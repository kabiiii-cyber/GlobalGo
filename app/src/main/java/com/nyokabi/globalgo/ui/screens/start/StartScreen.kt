package com.nyokabi.harakamall.ui.screens.start

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.nyokabi.globalgo.R
import com.nyokabi.globalgo.navigation.ROUT_HOME
import com.nyokabi.globalgo.navigation.ROUT_LOGIN
import com.nyokabi.globalgo.navigation.ROUT_REGISTER
import com.nyokabi.globalgo.navigation.ROUT_START
import com.nyokabi.globalgo.ui.theme.bluey
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun StartScreen(navController: NavController){

Column (
    modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,

){





    Spacer(modifier = Modifier.height(20.dp))


    Text(
        text = "Welcome to GlobalGo!!!",
        fontSize = 30.sp,
        fontWeight = FontWeight.ExtraBold,
        color = bluey
        )

    Spacer(modifier = Modifier.height(20.dp))


    Text(
        text = "Where your imposibility become possible",
        textAlign = TextAlign.Center,
        fontSize = 18.sp
        )


    Spacer(modifier = Modifier.height(20.dp))

    // Register Navigation Button
    TextButton(onClick = { navController.navigate(ROUT_LOGIN) },
        colors = ButtonDefaults.buttonColors(bluey),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.fillMaxWidth().padding(start =20.dp, end = 20.dp)
    ) {
        Text("Get Started")
    }




}


}

@Preview(showBackground = true)
@Composable
fun StartScreenPreview(){
    StartScreen(rememberNavController())
}