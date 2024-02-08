package com.kasia.sample.app.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kasia.sample.app.compose.routing.Screen
import com.kasia.sample.app.compose.ui.features.details.PetDetails
import com.kasia.sample.app.compose.ui.features.home.ListScreen
import com.kasia.sample.app.compose.ui.theme.SampleAppComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainActivityViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleAppComposeTheme {
                val navController = rememberNavController()
                Box(modifier = Modifier.fillMaxSize(), content = {
                    MainActivityScreen(navController = navController, viewModel)
                })
            }
        }
    }
}

@Composable
fun MainActivityScreen(
    navController: NavHostController,
    viewModel: MainActivityViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screen.ListScreen.route
    ) {
        composable(Screen.ListScreen.route) {
            ListScreen(viewModel = hiltViewModel(), viewModel) {
                navController.navigate(Screen.DetailsScreen.route)
            }
        }
        composable(Screen.DetailsScreen.route) {
            PetDetails(viewModel) { navController.popBackStack() }
        }
    }
}
