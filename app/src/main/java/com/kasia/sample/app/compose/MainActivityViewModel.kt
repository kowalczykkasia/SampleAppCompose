package com.kasia.sample.app.compose

import androidx.lifecycle.ViewModel
import com.kasia.sample.app.storage.db.ItemModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
) : ViewModel() {

    private var _detailsEntry = MutableStateFlow<ItemModel>(ItemModel())
    val detailsEntry: Flow<ItemModel> = _detailsEntry

    fun onItemSelected(item: ItemModel) {
        _detailsEntry.value = item
    }
}