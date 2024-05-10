package com.example.gilangtugasfrontend.navigation

sealed class Screen(val route: String){
    data object Home : Screen("home")
    data object Food : Screen("food")
    data object About : Screen("about")
    data object Detail : Screen("detail")
    data object DetailMusikTradisional: Screen("detail_musik_tradisional")
    data object DetailRumahAdat: Screen("detail_rumah_adat")
    data object DetailMakananTradisional: Screen("detail_makanan_tradisional")
}