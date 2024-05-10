package com.example.gilangtugasfrontend.presentation

import android.text.style.BackgroundColorSpan
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.BrowseGallery
import androidx.compose.material.icons.filled.FoodBank
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Topic
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.gilangtugasfrontend.R
import com.example.gilangtugasfrontend.navigation.NavigationItem
import com.example.gilangtugasfrontend.navigation.Screen
import com.example.gilangtugasfrontend.ui.theme.RedPrimary
import okhttp3.internal.wait

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val context = LocalContext.current

    val listJudul = mapOf(
        Screen.Home.route to stringResource(id = R.string.menu_home),
        Screen.Food.route to stringResource(id = R.string.menu_food),
        Screen.About.route to stringResource(id = R.string.menu_About),
        Screen.Detail.route to stringResource(id = R.string.menu_detail)
    )
    val judul = remember { mutableStateOf(listJudul[Screen.Home.route]) }


    Scaffold(
        topBar = {
            TopAppBar(

                title = { Text(
                    text = judul.value ?: "",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                ) },
                navigationIcon = {
                    if (judul.value == "Detail") {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = RedPrimary,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        },
        bottomBar = {
            BottomBar(navController)
        },
        modifier = modifier,
    ) { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = modifier.padding(contentPadding),
        ) {
            composable(Screen.Home.route) {
                judul.value = listJudul[Screen.Home.route]
                HomeScreen(navController)
            }

            composable(Screen.Food.route) {
                judul.value = listJudul[Screen.Food.route]
                MakananScreen(navController)
            }

            composable(Screen.About.route) {
                judul.value = listJudul[Screen.About.route]
                AboutScreen(navController) //sementara
            }

            composable(
                Screen.DetailMusikTradisional.route + "/{musikTradisionalId}",
                arguments = listOf(navArgument("musikTradisionalId") { type = NavType.IntType })
            ) { navBackStackEntry ->
                judul.value = listJudul[Screen.Detail.route]
                DetailMusikTradisionalScreen(
                    navController = navController,
                    musikTradisionalId = navBackStackEntry.arguments?.getInt("musikTradisionalId")
                )
            }

            composable(
                Screen.DetailRumahAdat.route + "/{rumahAdatId}",
                arguments = listOf(navArgument("rumahAdatId") { type = NavType.IntType })
            ) { navBackStackEntry ->
                judul.value = listJudul[Screen.Detail.route]
                DetailRumahAdatScreen(navController = navController,
                    rumahAdatId = navBackStackEntry.arguments?.getInt("rumahAdatId"))
            }
            composable(
                Screen.DetailMakananTradisional.route + "/{makananTradisionalId}",
                arguments = listOf(navArgument("makananTradisionalId") { type = NavType.IntType })
            ) { navBackStackEntry ->
                judul.value = listJudul[Screen.Detail.route]
                DetailMakananTradisionalScreen(navController = navController,
                    makananTradisionalId = navBackStackEntry.arguments?.getInt("makananTradisionalId"))
            }
        }
    }
}


@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        containerColor = RedPrimary
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(id = R.string.menu_home),
                icon = Icons.Default.Home,
                screen = Screen.Home
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_food),
                icon = Icons.Default.FoodBank,
                screen = Screen.Food
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_About),
                icon = Icons.Default.AccountCircle,
                screen = Screen.About
            )
        )
        navigationItems.map { item ->
            NavigationBarItem(
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                icon = { Icon(imageVector = item.icon, contentDescription = item.title, tint = Color.White) },
                label = { Text(
                    text = item.title,
                    color = Color.White) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ListAppPrev() {
    ListApp()
}