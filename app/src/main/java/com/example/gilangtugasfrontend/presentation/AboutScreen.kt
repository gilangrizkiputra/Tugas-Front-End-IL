package com.example.gilangtugasfrontend.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.gilangtugasfrontend.R
import com.example.gilangtugasfrontend.data.ListData
import com.example.gilangtugasfrontend.model.MusikTradisional
import com.example.gilangtugasfrontend.model.RumahAdat
import com.example.gilangtugasfrontend.navigation.Screen
import com.example.gilangtugasfrontend.presentation.component.MusikTradisionalItem
import com.example.gilangtugasfrontend.presentation.component.RumahAdatItem
import com.example.gilangtugasfrontend.ui.theme.GilangTugasFrontEndTheme
import com.example.gilangtugasfrontend.ui.theme.RedPrimary

@Composable
fun AboutScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    musikTradisional: List<MusikTradisional> = ListData.musikTradisionalIndonesia,
    rumahAdat: List<RumahAdat> = ListData.rumahAdatIndonesia,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.padding(top = 64.dp))
        Image(
            painter = painterResource(id = R.drawable.image_about),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(width = 200.dp, height = 200.dp)
                .background(color = RedPrimary)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = "Gilang Rizki Putra",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 32.dp)
        )
        Text(
            text = "gilangrizkiptra@gmail.com",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = "Universitas Gunadarma",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = "Informatika",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}