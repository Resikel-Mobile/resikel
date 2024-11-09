package com.example.resikel.report

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
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
import com.example.resikel.ui.theme.montserrat
import com.example.resikel.ui.theme.primaryGreen
import com.example.resikel.ui.theme.primaryWhite


@Composable
fun SuccessReport(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.background(color = primaryWhite).fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally, ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(160.dp))
            Image(
                painterResource(R.drawable.success_report),
                contentDescription = null,
                modifier = Modifier
                    .height(250.dp)
                    .width(250.dp)
            )
            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                textAlign = TextAlign.Center,
                text = "Report sent successfully! go back to homepage right now",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = primaryGreen
            )
        }
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = primaryGreen
            ),
            enabled = true,
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(top = 8.dp, start = 22.dp, end = 22.dp, bottom = 12.dp),
            onClick = {
                //TODO: KEMBALI KE HALAMAN HOME
            }) {
            Text(
                text = "Back to Home",
                fontWeight = FontWeight.Normal,
                color = Color.White,
                fontFamily = montserrat,
                fontSize = 16.sp,
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
private fun SuccessReportScreen() {
    ResikelTheme {
        SuccessReport()
    }
}