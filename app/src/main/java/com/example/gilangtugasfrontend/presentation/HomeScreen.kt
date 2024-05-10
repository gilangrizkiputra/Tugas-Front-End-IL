package com.example.gilangtugasfrontend.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gilangtugasfrontend.data.ListData
import com.example.gilangtugasfrontend.model.MusikTradisional
import com.example.gilangtugasfrontend.model.RumahAdat
import com.example.gilangtugasfrontend.navigation.Screen
import com.example.gilangtugasfrontend.presentation.component.MakananTradisionalItem
import com.example.gilangtugasfrontend.presentation.component.MusikTradisionalItem
import com.example.gilangtugasfrontend.presentation.component.RumahAdatItem

@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    musikTradisional: List<MusikTradisional> = ListData.musikTradisionalIndonesia,
    rumahAdat: List<RumahAdat> = ListData.rumahAdatIndonesia,
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Musik Tradisional Indonesia",
            fontSize = 18.sp,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = 16.dp)
        )
        LazyRow(
            contentPadding = PaddingValues(2.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier.padding(top = 8.dp)
        ) {
            items(musikTradisional, key = { it.id }) {
                MusikTradisionalItem(musikTradisional = it) { musikTradisionaltId ->
                    navController.navigate(Screen.DetailMusikTradisional.route + "/$musikTradisionaltId")
                }
            }
        }
        Text(
            text = "Rumah Adat Indonesia",
            fontSize = 18.sp,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier
        ) {
            items(rumahAdat, key = { it.id }) {
                RumahAdatItem(rumahAdat = it){ rumahAdatId ->
                    navController.navigate(Screen.DetailRumahAdat.route + "/$rumahAdatId")
                }
            }
        }
    }
}

