package com.kasia.sample.app.compose.ui.features.screens

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.integerResource
import com.kasia.sample.app.compose.R
import com.kasia.sample.app.compose.ui.features.images.ImageItem
import com.kasia.sample.app.storage.models.PhotosResponseModel

@Composable
fun ListScreen(viewModel: HomeViewModel) {
    val photos: List<PhotosResponseModel> by viewModel
        .photosList
        .collectAsState(initial = listOf())

    val list = photos.firstOrNull()?.items
    if (!list.isNullOrEmpty()) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(integerResource(id = R.integer.column_count))
        ) {
            items(list.count()) { index ->
                val item = list[index]
                ImageItem(item = item)
            }
        }
    }
}