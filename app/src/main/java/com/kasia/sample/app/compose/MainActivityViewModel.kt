package com.kasia.sample.app.compose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kasia.sample.app.compose.base.BaseViewModel
import com.kasia.sample.app.domain.models.Item
import com.kasia.sample.app.domain.usecases.FetchAndSaveDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class MainActivityViewModel@Inject constructor() : BaseViewModel() {

    private var _detailsEntry = MutableStateFlow(Item())
    val detailsEntry: Flow<Item> = _detailsEntry

    fun onItemSelected(item: Item) {
        _detailsEntry.value = item
    }
}