package com.nyokabi.globalgo.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.nyokabi.globalgo.R
import com.nyokabi.globalgo.navigation.ROUT_STUDENT
import com.nyokabi.globalgo.ui.theme.dblue
import com.nyokabi.globalgo.ui.theme.newgrey
import com.nyokabi.globalgo.ui.theme.white

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().paint(
            painter = painterResource(R.drawable.img_9),
            contentScale = ContentScale.FillHeight,
        )
    ) {
        Box {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(800.dp)
                    .padding(start = 40.dp, end = 40.dp, top = 40.dp),
                shape = RoundedCornerShape(60.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 50.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "Welcome to GlobalGo",
                        fontSize = 30.sp,
                        color = dblue,
                        fontStyle = FontStyle.Italic
                    )

                    Spacer(modifier = Modifier.height(50.dp))

                    Card(
                        modifier = Modifier
                            .width(150.dp)
                            .height(180.dp),
                        elevation = CardDefaults.cardElevation()
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.img_12),
                                contentDescription = "home",
                                modifier = Modifier.size(100.dp)
                            )
                            Text(text = "Choose account type", fontSize = 15.sp)
                        }
                    }

                    Spacer(modifier = Modifier.height(50.dp))

                    // Account Selection Buttons
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(
                            16.dp,
                            Alignment.CenterHorizontally
                        ), // Adds space between buttons
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(
                            onClick = { navController.navigate(ROUT_STUDENT) },
                            shape = RoundedCornerShape(20.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue) // Sets button color
                        ) {
                            Text(text = "Student")
                        }

                        Button(
                            onClick = { navController.navigate("school") },
                            shape = RoundedCornerShape(20.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue) // Sets button color
                        ) {
                            Text(text = "School")
                        }
                    }
                }
            }
        }
    }
}


















                    @Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(navController= rememberNavController())
}