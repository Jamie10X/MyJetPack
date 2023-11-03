package com.example.myjetpack.bottom_navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController

@Composable
fun MyBottomNavigation(navController: NavController) {
    val destinationList = listOf<Destinations>(
        Home,
        Settings
    )
    val selectedIndex = rememberSaveable{
        mutableStateOf(0)
    }
    BottomNavigation {
        destinationList.forEachIndexed{index, destinations -> BottomNavigationItem(
            label = { Text(text = destinations.title)},
            icon = {
                Icon(ImageVector = destinations.icon, contentDescription = destinations.title)
            },
            selected = index == selectedIndex.value,
            onClick = {
                selectedIndex.value = index
                navController.navigate(destinationList[index].route){
                    popUpTo(Home.route)
                    launchSingleTop = true
                }
            }

        )
        } }
    }

fun Icon(ImageVector: ImageVector, contentDescription: String) {
    "HomeScreen"
}
