package com.example.resikel.report

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import coil.compose.AsyncImage
import com.example.resikel.ui.theme.ResikelTheme
import com.example.resikel.ui.theme.montserrat
import com.example.resikel.ui.theme.primaryGreen
import com.example.resikel.ui.theme.primaryGrey
import com.example.resikel.ui.theme.primaryWhite
import com.example.resikel.ui.theme.secondaryGreen
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Objects

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReportScreen(modifier: Modifier = Modifier) {

    //description editText
    var description by remember { mutableStateOf("") }

    var checked by remember { mutableStateOf(false) }

    //camera
    val context = LocalContext.current
    val file = context.createImageFile()
    val uri = FileProvider.getUriForFile(
        Objects.requireNonNull(context),
        context.packageName + ".provider", file
    )

    var selectedImageUri by remember {
        mutableStateOf<Uri?>(null)
    }

    val cameraLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.TakePicture()
    ) {
        selectedImageUri = uri
    }

    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) {
        if (it) {
            Toast.makeText(context, "Permission Granted", Toast.LENGTH_SHORT).show()
            cameraLauncher.launch(uri)
        } else {
            Toast.makeText(context, "Permission Denied", Toast.LENGTH_SHORT).show()
        }
    }

    //gallery picker
    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri -> selectedImageUri = uri }
    )

    //TODO: Buat customize top Bar
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Create Report") },
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = primaryGreen,
                titleContentColor = primaryWhite,
                navigationIconContentColor = primaryWhite
            )
        )
    }) { innerPadding ->
        val isOpenDialog = remember { mutableStateOf(false) }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(color = primaryWhite),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .background(
                        color = primaryGreen,
                        shape = RoundedCornerShape(bottomEnd = 48.dp, bottomStart = 48.dp)
                    )
            )
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                //insert photo
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    colors = CardDefaults.cardColors(containerColor = primaryWhite),
                    elevation = CardDefaults.cardElevation(10.dp),
                ) {
                    Column(modifier = Modifier
                        .padding(16.dp)
                        .clickable {
                            isOpenDialog.value = true
                        }) {
                        Text(
                            text = "Insert Photo",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(text = "Take or upload location photos", fontSize = 12.sp)
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                                .background(color = primaryGrey, shape = RoundedCornerShape(8.dp))
                        ) {
                            if (selectedImageUri != null) {
                                AsyncImage(
                                    model = selectedImageUri,
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                        }
                        if(selectedImageUri != null){
                            Row(modifier = Modifier.padding(top = 8.dp)) {
                                Spacer(modifier = Modifier.weight(1f))
                                Button(
                                    onClick = {
                                        isOpenDialog.value = true
                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = secondaryGreen,
                                    )
                                ) {
                                    Text(text = "Change photo")
                                }
                            }
                        }
                    }
                }

                //detailed Report
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    colors = CardDefaults.cardColors(containerColor = primaryWhite),
                    elevation = CardDefaults.cardElevation(10.dp),
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "Write detailed reports",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(text = "description", fontSize = 13.sp)
                        OutlinedTextField(
                            value = description,
                            onValueChange = { description = it},
                            label = { Text("description") },
                            modifier = Modifier.fillMaxWidth()
                        )
                        Text(
                            text = "Set a more accurate illegal TPS report location",
                            fontSize = 13.sp
                        )
                        Row {
                            Spacer(modifier = Modifier.weight(1f))
                            Button(
                                onClick = {

                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = secondaryGreen,
                                )
                            ) {
                                Text(text = "Select Location")
                            }
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceAround,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Checkbox(
                                checked = checked,
                                onCheckedChange = { checked = it}
                            )
                            Text(text = "I'm responsible for the report I make", fontSize = 13.sp)
                        }

                    }
                }

                //button continue
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = primaryGreen
                    ),
                    //TODO: hanya enable ketika semua field telah terisi
                    enabled = checked,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .padding(top = 8.dp, start = 22.dp, end = 22.dp, bottom = 12.dp),
                    onClick = {}) {
                    Text(
                        text = "Continue",
                        fontWeight = FontWeight.Normal,
                        color = Color.White,
                        fontFamily = montserrat,
                        fontSize = 22.sp,
                    )
                }

            }
            if (isOpenDialog.value) {
                //Custom Dialog
                Dialog(onDismissRequest = { isOpenDialog.value = false }) {
                    Card(
                        shape = RoundedCornerShape(10.dp),
                        elevation = CardDefaults.cardElevation(8.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .background(primaryWhite)
                                .padding(16.dp),
                            Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = "Take a photo or choose from the gallery?",
                                fontWeight = FontWeight.Bold,
                                fontSize = 24.sp, textAlign = TextAlign.Center
                            )
                            Button(
                                modifier = Modifier.fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = primaryGreen,
                                ),
                                shape = RoundedCornerShape(10.dp),
                                //TODO: IMPLEMENT TAKE PICTURE
                                onClick = {
                                    val permissionCheckResult =
                                        ContextCompat.checkSelfPermission(
                                            context,
                                            Manifest.permission.CAMERA
                                        )
                                    if (permissionCheckResult == PackageManager.PERMISSION_GRANTED) {
                                        cameraLauncher.launch(uri)
                                    } else {
                                        permissionLauncher.launch(Manifest.permission.CAMERA)
                                    }
                                    isOpenDialog.value = false
                                }) {
                                Text(text = "Take a photo", fontSize = 18.sp)
                            }
                            OutlinedButton(
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(10.dp),
                                //TODO: IMPLEMENT OPEN GALLERY
                                onClick = {
                                    photoPickerLauncher.launch(
                                        PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                                    )
                                    isOpenDialog.value = false
                                },
                            ) {
                                Text(
                                    text = "Choose from gallery",
                                    color = primaryGreen,
                                    fontSize = 18.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }


}


fun Context.createImageFile(): File {
    val timeStamp = SimpleDateFormat("yyyy_MM_dd_HH:mm:ss").format(Date())
    val imageFileName = "JPEG_" + timeStamp + "_"
    val image = File.createTempFile(
        imageFileName,
        ".jpg",
        externalCacheDir
    )

    return image
}

@Preview
@Composable
private fun ReportScreenPreview() {
    ResikelTheme {
        ReportScreen()
    }
}