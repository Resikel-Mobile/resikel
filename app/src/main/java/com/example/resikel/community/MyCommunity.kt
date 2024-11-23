package com.example.resikel.community

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.resikel.R
import com.example.resikel.ui.theme.ResikelTheme
import com.example.resikel.ui.theme.primaryGreen
import com.example.resikel.ui.theme.primaryWhite
import com.example.resikel.ui.theme.softWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCommunity(modifier: Modifier = Modifier) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Community") },
            navigationIcon = {
                IconButton(onClick = {}) {
                    Box(
                        modifier = Modifier
                            .background(color = Color.White, CircleShape)
                            .padding(8.dp)
                    ) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                    }

                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = primaryGreen,
                titleContentColor = primaryWhite,
//                navigationIconContentColor = primaryWhite
            )
        )
    }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(
                    softWhite
                ),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //Title Section
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.3f)
            ) {
                Image(
                    painterResource(R.drawable.community_bg),
                    contentDescription = null,
                    modifier = Modifier
                        .size(260.dp)
                        .align(Alignment.Center)
                )
                Text(
                    text = "My\ncommunity",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(
                        Alignment.Center
                    )
                )
            }
            //Community Section
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                    .background(
                        softWhite
                    )
                    .padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                //Community Item - OnClick menuju halaman Detail Community
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painterResource(R.drawable.resikel_green),
                        contentDescription = null,
                        modifier = Modifier.size(64.dp)
                    )
                    Text(text = "Resikel", fontWeight = FontWeight.Bold)
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = null,
                        tint = Color.Cyan
                    )
                }
                HorizontalDivider()
                //Community Item - OnClick menuju halaman Announcement
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painterResource(R.drawable.ic_announcement),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(8.dp)
                            .size(40.dp)
                    )
                    Text(text = "Announcement", fontWeight = FontWeight.Bold)
                }
            }
            HorizontalDivider(thickness = 4.dp, color = primaryGreen)
            //Chat Section
            Column(
                horizontalAlignment = Alignment.Start, modifier = Modifier
                    .fillMaxWidth()
            ) {
                //Chat Item - OnClick menuju halaman Chat
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.Top,
                    modifier = Modifier.padding(top = 4.dp, start = 8.dp, end = 8.dp)
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
                            Text(text = "Kantor Pejantara", fontWeight = FontWeight.Bold)
                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = null,
                                tint = Color.Cyan
                            )
                        }
                        Text(
                            text = "Silahkan Mang bisa datang langsung Kesini",
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
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun MyCommunityPreview() {
    ResikelTheme {
        MyCommunity()
    }
}