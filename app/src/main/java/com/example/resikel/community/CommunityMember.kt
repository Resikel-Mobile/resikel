package com.example.resikel.community

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.resikel.R
import com.example.resikel.ui.theme.ResikelTheme
import com.example.resikel.ui.theme.primaryGreen
import com.example.resikel.ui.theme.primaryWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommunityMember(modifier: Modifier = Modifier) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Community Members") },
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
    }) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).fillMaxSize().padding(top = 16.dp, start = 8.dp, end = 8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            //TODO: nanti pake lazy row
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(painterResource(R.drawable.user_placeholder), contentDescription = null, modifier = Modifier.size(48.dp))
                Text("You", fontSize = 14.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.weight(1f))
                Text("Community Admin", fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = primaryGreen)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(painterResource(R.drawable.user_placeholder), contentDescription = null, modifier = Modifier.size(48.dp))
                Text("+62 12345678", fontSize = 14.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.weight(1f))
                Text("Community Admin", fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = primaryGreen)
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
    }

}

@Preview(showBackground = true)
@Composable
private fun CommunityMemberPreview() {
    ResikelTheme {
        CommunityMember()
    }
}