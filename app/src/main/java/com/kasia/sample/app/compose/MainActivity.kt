package com.kasia.sample.app.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kasia.sample.app.compose.routing.Screen
import com.kasia.sample.app.compose.ui.features.screens.ListScreen
import com.kasia.sample.app.compose.ui.theme.SampleAppComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleAppComposeTheme {
                val navController = rememberNavController()
                Box(modifier = Modifier.fillMaxSize(), content = {
                    MainActivityScreen(navController = navController)
                })
            }
        }
    }
}

@Composable
fun MainActivityScreen(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.ListScreen.route
    ) {
        composable(Screen.ListScreen.route) {
            ListScreen(viewModel = hiltViewModel()) //todo later go to details
        }
    }
}
