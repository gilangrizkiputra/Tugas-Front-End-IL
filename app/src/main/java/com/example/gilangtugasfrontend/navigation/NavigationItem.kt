package com.example.gilangtugasfrontend.navigation

import android.icu.text.CaseMap.Title
import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val title: String,
    val icon: ImageVector,
    val screen: Screen
)
