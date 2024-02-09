package com.kasia.sample.app.compose.ui.features.home

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.integerResource
import com.kasia.sample.app.compose.MainActivityViewModel
import com.kasia.sample.app.compose.R
import com.kasia.sample.app.storage.db.ItemModel

@Composable
fun ListScreen(viewModel: HomeViewModel, mainActivityViewModel: MainActivityViewModel, onNavigateToDetails: () -> Unit) {
    val photos: List<ItemModel> by viewModel
        .photosList
        .collectAsState(initial = listOf())

    val list = photos
    if (list.isNotEmpty()) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(integerResource(id = R.integer.column_count))
        ) {
            items(list.count()) { index ->
                val item = list[index]
                ImageItem(item = item, mainActivityViewModel, onNavigateToDetails)
            }
        }
    }
}