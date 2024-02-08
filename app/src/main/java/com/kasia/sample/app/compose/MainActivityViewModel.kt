package com.kasia.sample.app.compose

import androidx.lifecycle.ViewModel
import com.kasia.sample.app.storage.models.Item
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
) : ViewModel() {

    private var _detailsEntry = MutableStateFlow<Item>(Item())
    val detailsEntry: Flow<Item> = _detailsEntry

    fun onItemSelected(item: Item) {
        _detailsEntry.value = item
    }
}