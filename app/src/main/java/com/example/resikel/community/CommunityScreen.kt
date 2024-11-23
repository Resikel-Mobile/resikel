package com.example.resikel.community

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.resikel.R
import com.example.resikel.ui.theme.ResikelTheme
import com.example.resikel.ui.theme.primaryWhite
import com.example.resikel.ui.theme.redText

@Composable
fun CommunityScreen(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize()) {
            //background
            Image(
                painterResource(R.drawable.community_screen_bg),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(300.dp)
                    .fillMaxWidth()
            )
            //back icon
            Box(
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp)
                    .background(color = Color.White, CircleShape)
                    .padding(8.dp)
            ) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp),
                verticalArrangement = Arrangement.Center
            ) {
                //community header
                Row {
                    Image(painterResource(R.drawable.logo1), contentDescription = null)
                    Column(
                        modifier = Modifier.padding(top = 40.dp),
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                text = "Resikel",
                                fontWeight = FontWeight.Bold,
                                fontSize = 24.sp,
                                color = primaryWhite
                            )
                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = null, tint = Color.Cyan
                            )
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .border(
                                        BorderStroke(1.dp, Color.White),
                                        RoundedCornerShape(15.dp)
                                    )
                                    .padding(4.dp)
                            ) {
                                Text(
                                    text = "Community",
                                    fontWeight = FontWeight.Bold,
                                    color = primaryWhite,
                                    fontSize = 12.sp
                                )
                            }

                            Text(text = "|", fontWeight = FontWeight.Bold, color = primaryWhite)
                            Box(
                                modifier = Modifier
                                    .border(
                                        BorderStroke(1.dp, Color.White),
                                        RoundedCornerShape(15.dp)
                                    )
                                    .padding(4.dp)
                            ) {
                                Text(
                                    text = "View Member",
                                    fontWeight = FontWeight.Bold,
                                    color = primaryWhite, fontSize = 12.sp
                                )
                            }
                        }
                    }
                }
                //community description
                Column(modifier = Modifier.padding(start = 16.dp)) {
                    Text(text = "Community Info", color = Color.White, fontWeight = FontWeight.Bold)
                    Text(
                        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                        color = Color.White
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.Top,
                    modifier = Modifier.padding(top = 32.dp, start = 8.dp, end = 8.dp)
                ) {
                    Image(
                        painterResource(R.drawable.resikel_green),
                        contentDescription = null,
                        modifier = Modifier.size(64.dp)
                    )
                    Column(
                        modifier = Modifier
                            .padding(top = 4.dp)
                            .weight(1f)
                    ) {
                        Row {
                            Text(text = "Resikel", fontWeight = FontWeight.Bold)
                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = null,
                                tint = Color.Cyan
                            )
                        }
                        Text(
                            text = "untuk minggu ini jadwal pengumpulan sampah",
                            fontSize = 14.sp,
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 1
                        )
                    }
                    Column {
                        Text(text = "9:41 AM", fontSize = 12.sp, fontWeight = FontWeight.Light)
                    }
                }
            }
            Row(modifier = Modifier.align(Alignment.BottomCenter).padding(16.dp)) {
                Icon(Icons.AutoMirrored.Filled.ExitToApp, contentDescription = null, tint = redText)
                Text(
                    "Exit community",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = redText
                )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CommunityPreview() {
    ResikelTheme {
        CommunityScreen()
    }
}