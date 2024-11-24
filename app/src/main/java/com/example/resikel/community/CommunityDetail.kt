package com.example.resikel.community

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.resikel.R
import com.example.resikel.ui.theme.ResikelTheme
import com.example.resikel.ui.theme.primaryGreen
import com.example.resikel.ui.theme.redText

@Composable
fun CommunityDetail(modifier: Modifier = Modifier) {
    Column {
        Box(modifier = Modifier.fillMaxWidth()) {
            //background
            Image(
                painterResource(R.drawable.community_screen_bg),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(200.dp)
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
            Image(painterResource(R.drawable.logo1), contentDescription = null, modifier = Modifier.size(200.dp).align(Alignment.TopCenter))
        }
        Column(modifier = Modifier.fillMaxWidth().padding(top = 16.dp, start = 16.dp, end = 16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "Resikel",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                )
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = null, tint = Color.Cyan
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "Community",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                )
                Text(
                    text = "|",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                )
                Text(
                    text = "4 Groups",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            HorizontalDivider()
            Text("Community Info", fontWeight = FontWeight.SemiBold)
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit Lorem ipsum dolor sit amet, consectetur adipiscing elit", textAlign = TextAlign.Justify, fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(16.dp))

        }
        Column(modifier = Modifier.padding(16.dp).weight(1f), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text("Community Member", fontWeight = FontWeight.SemiBold)
            //TODO: nanti pake lazy row
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(painterResource(R.drawable.user_placeholder), contentDescription = null, modifier = Modifier.size(48.dp))
                Text("You", fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(painterResource(R.drawable.user_placeholder), contentDescription = null, modifier = Modifier.size(48.dp))
                Text("+62 12345678", fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(painterResource(R.drawable.user_placeholder), contentDescription = null, modifier = Modifier.size(48.dp))
                Text("+62 12345678", fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(painterResource(R.drawable.user_placeholder), contentDescription = null, modifier = Modifier.size(48.dp))
                Text("+62 12345678", fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(painterResource(R.drawable.user_placeholder), contentDescription = null, modifier = Modifier.size(48.dp))
                Text("+62 12345678", fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(painterResource(R.drawable.user_placeholder), contentDescription = null, modifier = Modifier.size(48.dp))
                Text("+62 12345678", fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
            }
            Text("View 200 more", color = primaryGreen, fontSize = 16.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        }
        HorizontalDivider(thickness = 4.dp, color = primaryGreen, modifier = Modifier.fillMaxWidth())
        Row(modifier = Modifier.padding(16.dp).fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
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

@Preview(showBackground = true)
@Composable
private fun CommunityDetailPreview() {
    ResikelTheme {
        CommunityDetail()
    }
}