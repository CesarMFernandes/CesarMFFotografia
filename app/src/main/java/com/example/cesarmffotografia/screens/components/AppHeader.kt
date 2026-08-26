package com.example.cesarmffotografia.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cesarmffotografia.R

@Composable
fun AppHeader() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.White)
            .border(
                width = 2.dp,
                color = Color.Black
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start ,

    ) {

        // SLOT DA LOGO

        Image(
            painter = painterResource(R.drawable.photobomb),
            contentDescription = "[LOGO]",
            modifier = Modifier.size(150.dp)
        )

        Text(
            text = "Photobomb - Fotojornalismo Documental",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}