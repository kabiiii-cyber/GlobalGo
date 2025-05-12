package com.nyokabi.globalgo.ui.screens.about

import android.content.Context
import android.net.Uri
import android.os.Environment
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.nyokabi.globalgo.R
import com.nyokabi.globalgo.navigation.ROUT_START
import com.nyokabi.globalgo.ui.theme.bluey
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

@Composable
fun StudentScreen(navController: NavController, context: Context) {
    var admissionNumber by remember { mutableStateOf("") }
    var fileUri by remember { mutableStateOf<Uri?>(null) }
    var uploadStatus by remember { mutableStateOf<String?>(null) }

    val filePicker = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) {
        fileUri = it
        uploadStatus = null
    }
    Column(modifier = Modifier.padding(16.dp).fillMaxSize().paint(painter = painterResource(
        R.drawable.img_14
    ), contentScale = ContentScale.FillBounds),
        horizontalAlignment = androidx.compose.ui.Alignment.Companion.CenterHorizontally,) {
        Spacer(modifier = Modifier.height(20.dp))



        BasicText("STUDENT CERTIFICATE")

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = admissionNumber,
            onValueChange = { admissionNumber = it.uppercase() },
            label = { Text("Admission Number") },
            placeholder = { Text("e.g. ADM1234") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth().padding(start = 30.dp, end = 30.dp,top= 50.dp)
        )


        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { downloadCertificate(context) },
            colors = ButtonDefaults.buttonColors(bluey),


        ) {
            Text("Download Certificate")
        }


        Spacer(modifier = Modifier.height(20.dp))


    }
}

fun downloadCertificate(context: Context) {
    val fileName = "certificate.pdf"
    val directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
    val file = File(directory, fileName)

    try {
        FileOutputStream(file).use { output ->
            output.write("Your Certificate Data Goes Here".toByteArray())
        }
        println("Certificate saved: ${file.absolutePath}")
    } catch (e: IOException) {
        e.printStackTrace()
    }
}

@Preview(showBackground = true)
@Composable
fun StudentScreenPreview() {
    val context = androidx.compose.ui.platform.LocalContext.current
    StudentScreen(navController = rememberNavController(), context)
}
