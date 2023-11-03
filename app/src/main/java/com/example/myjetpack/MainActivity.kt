package com.example.myjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myjetpack.bottom_navigation.Home
import com.example.myjetpack.bottom_navigation.HomeScreen
import com.example.myjetpack.bottom_navigation.MyBottomNavigation
import com.example.myjetpack.bottom_navigation.Settings
import com.example.myjetpack.bottom_navigation.SettingsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp(){
    val navController = rememberNavController()
    Scaffold (bottomBar = { MyBottomNavigation(navController = navController)}) {
   Box (Modifier.padding(it)){
       NavHost(navController = navController, startDestination = Home.route) {
           composable(Home.route){
               HomeScreen()
           }
           composable(Settings.route){
               SettingsScreen()
           }
       }

   }
    }
}