import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Environment
import androidx.core.content.FileProvider
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nyokabi.globalgo.R
import com.nyokabi.globalgo.ui.theme.bluey
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

@Composable
fun StudentScreen(navController: NavController, context: Context) {
    var admissionNumber by remember { mutableStateOf("") }
    var message by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .paint(
                painter = painterResource(R.drawable.img_14),
                contentScale = ContentScale.FillBounds
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        Text("STUDENT CERTIFICATE", style = MaterialTheme.typography.titleLarge)

        OutlinedTextField(
            value = admissionNumber,
            onValueChange = { admissionNumber = it.uppercase() },
            label = { Text("Admission Number") },
            placeholder = { Text("e.g. ADM1234") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 32.dp)
        )

        Button(
            onClick = {
                if (admissionNumber.isNotBlank()) {
                    val file = saveCertificate(context, admissionNumber)
                    openPdf(context, file)
                    message = "Certificate saved ."
                } else {
                    message = "Enter admission number first."
                }
            },
            colors = ButtonDefaults.buttonColors(bluey)
        ) {
            Text("Download ")
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
                onClick = { navController.navigate("home") },
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue) // Sets button color
            ) {
                Text(text = "Home")
            }

            Button(
                onClick = { navController.navigate("school") },
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue) // Sets button color
            ) {
                Text(text = "School")
            }
        }


        message?.let {
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = it)
        }
    }
}

fun saveCertificate(context: Context, admissionNumber: String): File {
    val fileName = "${admissionNumber}_certificate.pdf"
    val directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
    val file = File(directory, fileName)

    try {
        FileOutputStream(file).use { output ->
            output.write("Certificate for $admissionNumber".toByteArray())
        }
    } catch (e: IOException) {
        e.printStackTrace()
    }

    return file
}

fun openPdf(context: Context, file: File) {
    try {
        val uri: Uri = FileProvider.getUriForFile(
            context,
            "${context.packageName}.provider",
            file
        )

        val intent = Intent(Intent.ACTION_VIEW).apply {
            setDataAndType(uri, "application/pdf")
            flags = Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_ACTIVITY_NEW_TASK
        }

        context.startActivity(intent)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}