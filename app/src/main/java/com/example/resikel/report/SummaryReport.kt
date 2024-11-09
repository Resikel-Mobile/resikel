package com.example.resikel.report

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.resikel.ui.theme.ResikelTheme
import com.example.resikel.ui.theme.montserrat
import com.example.resikel.ui.theme.primaryGreen
import com.example.resikel.ui.theme.primaryGrey
import com.example.resikel.ui.theme.primaryWhite
import com.example.resikel.ui.theme.secondaryGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SummaryReport(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    //TODO: implementasi penerimaan data dari create report screen
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Summary Report") },
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

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(color = primaryWhite),
        ) {
            Column(modifier = Modifier.verticalScroll(scrollState)) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .background(
                            color = primaryGrey
                        )
                )
                //report description
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
                            text = "Description",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            text = "It has been 10 days since the rubbish has been piled up without any handling from the responsible parties",
                            fontSize = 12.sp
                        )
                        Text(
                            text = "Location", fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Row {
                            Icon(
                                Icons.Default.LocationOn,
                                contentDescription = null,
                            )
                            Text(
                                text = "Jalan Telekomunikasi No.1 RT.005 / RW.10",
                                fontSize = 12.sp
                            )
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(140.dp)
                                .background(
                                    color = primaryGrey
                                )
                        )
                    }
                }
                //report sender info
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    colors = CardDefaults.cardColors(containerColor = primaryWhite),
                    elevation = CardDefaults.cardElevation(10.dp),
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "Reporter", fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Box(
                                modifier = Modifier
                                    .width(48.dp)
                                    .height(48.dp)
                                    .clip(CircleShape)
                                    .background(
                                        color = primaryGrey
                                    )
                            )
                            Column {
                                Text(
                                    text = "Robert Junior", fontSize = 12.sp,
                                    fontWeight = FontWeight.Medium
                                )
                                Text(
                                    text = "Report Created", fontSize = 12.sp,
                                )
                            }
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "24 October 2024", fontSize = 12.sp,
                                fontWeight = FontWeight.Light
                            )
                            Text(
                                text = "12:30:05 WIB", fontSize = 12.sp,
                                fontWeight = FontWeight.Light
                            )
                        }
                    }
                }
                //button
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        colors = ButtonDefaults.buttonColors(
                            containerColor = secondaryGreen
                        ),
                        enabled = true,
                        modifier = Modifier
                            .height(80.dp)
                            .padding(top = 8.dp, start = 22.dp, end = 22.dp, bottom = 12.dp)
                            .weight(1f),
                        onClick = {
                            //TODO: KEMBALI KE HALAMAN CREATE REPORT
                        }) {
                        Text(
                            text = "Back to Edit",
                            fontWeight = FontWeight.Normal,
                            color = Color.White,
                            fontFamily = montserrat,
                            fontSize = 16.sp,
                        )
                    }
                    Button(
                        colors = ButtonDefaults.buttonColors(
                            containerColor = primaryGreen
                        ),
                        enabled = true,
                        modifier = Modifier
                            .height(80.dp)
                            .padding(top = 8.dp, start = 22.dp, end = 22.dp, bottom = 12.dp)
                            .weight(1f),
                        onClick = {
                            //TODO: MENUJU HALAMAN SUCCESS
                        }) {
                        Text(
                            text = "Submit",
                            fontWeight = FontWeight.Normal,
                            color = Color.White,
                            fontFamily = montserrat,
                            fontSize = 16.sp,
                        )
                    }
                }

            }
        }
    }
}

@Preview
@Composable
private fun SummaryReportScreenPreview() {
    ResikelTheme {
        SummaryReport()
    }
}