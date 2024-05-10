package com.example.gilangtugasfrontend.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gilangtugasfrontend.data.ListData
import com.example.gilangtugasfrontend.model.MakananTradisional
import com.example.gilangtugasfrontend.model.MusikTradisional
import com.example.gilangtugasfrontend.model.RumahAdat
import com.example.gilangtugasfrontend.navigation.Screen
import com.example.gilangtugasfrontend.presentation.component.MakananTradisionalItem
import com.example.gilangtugasfrontend.presentation.component.MusikTradisionalItem
import com.example.gilangtugasfrontend.ui.theme.GilangTugasFrontEndTheme

@Composable
fun MakananScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    makananTradisional: List<MakananTradisional> = ListData.makananTradisionalIndonesia
) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        columns = GridCells.Adaptive(140.dp),
        modifier = modifier.fillMaxSize()
    ) {
        items(makananTradisional, key = { it.id }) {
            MakananTradisionalItem(makananTradisional = it){ makananTradisionalId ->
                navController.navigate(Screen.DetailMakananTradisional.route + "/$makananTradisionalId")
            }
        }
    }
}
