package com.kasia.sample.app.compose.ui.features.home

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.kasia.sample.app.compose.MainActivityViewModel
import com.kasia.sample.app.compose.R
import com.kasia.sample.app.domain.models.Item

@Composable
fun ListScreen(viewModel: HomeViewModel, mainActivityViewModel: MainActivityViewModel, onNavigateToDetails: () -> Unit) {
    val photos: List<Item> by viewModel
        .photosList
        .collectAsState(initial = listOf())

    val error by viewModel.error.collectAsState(null)
    error?.let {
        Toast.makeText(LocalContext.current, it.message, Toast.LENGTH_SHORT).show()
    }
    Log.d("HALKO", "${photos}")
    LazyVerticalGrid(
        columns = GridCells.Fixed(integerResource(id = R.integer.column_count))
    ) {
        Log.d("HALKO", "${photos.count()}")
        items(photos.count()) { index ->
            val item = photos[index]
            ImageItem(item = item, mainActivityViewModel, onNavigateToDetails)
        }
    }
}