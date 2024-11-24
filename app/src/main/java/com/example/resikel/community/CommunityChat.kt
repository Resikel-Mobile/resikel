package com.example.resikel.community

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.resikel.R
import com.example.resikel.ui.theme.ResikelTheme
import com.example.resikel.ui.theme.chatBackground
import com.example.resikel.ui.theme.chatTextFieldBg
import com.example.resikel.ui.theme.primaryGreen
import com.example.resikel.ui.theme.primaryWhite
import com.example.resikel.ui.theme.softWhite

@Composable
fun CommunityChat() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = chatBackground)
    ) {
        //App Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = primaryGreen)
                .padding(start = 16.dp, end = 16.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null,
                tint = primaryWhite
            )
            Image(
                painterResource(R.drawable.logo1),
                contentDescription = null,
                modifier = Modifier.size(98.dp)
            )
            Column(modifier = Modifier.weight(1f)) {
                Text("Resikel [Batam Kota]", color = primaryWhite)
                Text("Tap here for more info", color = primaryWhite)
            }
            Image(
                painterResource(R.drawable.group_setting),
                contentDescription = null,
                modifier = Modifier.size(44.dp)
            )
        }
        //Chat List
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Text(
                "Today",
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Box(
                modifier = Modifier
                    .padding(end = 16.dp)
                    .width(280.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(color = softWhite)
                    .padding(8.dp)
                    .align(Alignment.End)
            ) {
                Column {
                    Text(
                        "Selamat pagi semua! \uD83C\uDF1E Ada yang tahu jadwal pengumpulan sampah daur ulang di lingkungan kita minggu ini?",
                        textAlign = TextAlign.Justify
                    )
                    Text("10:43 AM", color = primaryGreen, fontSize = 12.sp, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.End)
                }
            }
            Row(modifier = Modifier.padding(start = 16.dp, top = 16.dp)) {
                Image(
                    painterResource(R.drawable.user_placeholder),
                    contentDescription = null,
                    modifier = Modifier.size(44.dp)
                )
                Box(
                    modifier = Modifier
                        .width(280.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(color = primaryWhite)
                        .padding(8.dp)
                ) {
                    Column {
                        Text("Milo", color = primaryGreen, fontWeight = FontWeight.Bold)
                        Text(
                            "Untuk minggu ini, jadwal pengumpulan sampah daur ulang ada di hari Rabu dan Sabtu, ya. Jangan lupa memilah sampahnya! ♻\uFE0F",
                            textAlign = TextAlign.Justify
                        )
                        Text("10:43 AM", color = primaryGreen, fontSize = 12.sp)
                    }
                }
            }

        }
        //Chat text field
        Column(modifier = Modifier.background(color = chatTextFieldBg)) {
            TextField(
                placeholder = { Text("Type a message here") },
                value = "",
                shape = RoundedCornerShape(15.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(242, 243, 247),
                    unfocusedContainerColor = Color(242, 243, 247),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                leadingIcon = { Icon(Icons.Default.Face, contentDescription = null) },
                trailingIcon = { Icon(Icons.AutoMirrored.Filled.Send, contentDescription = null) },
                onValueChange = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun CommunityChatPreview() {
    ResikelTheme {
        CommunityChat()
    }
}