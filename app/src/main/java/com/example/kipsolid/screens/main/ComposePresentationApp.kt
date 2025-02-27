package com.example.kipsolid.screens.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kipsolid.screens.author.AuthorScreen
import com.example.kipsolid.screens.feature.FeaturesScreen
import com.example.kipsolid.screens.intro.IntroScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposePresentationApp() {
        val navController = rememberNavController()

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Jetpack Compose Презентація") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                )
            },
            bottomBar = {
                NavigationBar(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                ) {
                    NavigationBarItem(
                        selected = navController.currentBackStackEntry?.destination?.route == "intro",
                        onClick = { navController.navigate("intro") },
                        icon = { Icon(Icons.Default.Info, contentDescription = "Про Compose") },
                        label = { Text("Про Compose") }
                    )

                    NavigationBarItem(
                        selected = navController.currentBackStackEntry?.destination?.route == "features",
                        onClick = { navController.navigate("features") },
                        icon = { Icon(Icons.Default.Star, contentDescription = "Можливості") },
                        label = { Text("Можливості") }
                    )

                    NavigationBarItem(
                        selected = navController.currentBackStackEntry?.destination?.route == "author",
                        onClick = { navController.navigate("author") },
                        icon = { Icon(Icons.Default.Person, contentDescription = "Автор") },
                        label = { Text("Автор") }
                    )
                }
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = "intro",
                modifier = Modifier.padding(innerPadding)
            ) {
                composable("intro") {
                    IntroScreen()
                }
                composable("features") {
                    FeaturesScreen()
                }
                composable("author") {
                    AuthorScreen()
                }
            }
        }
    }
