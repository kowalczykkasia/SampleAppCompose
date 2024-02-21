package com.kasia.sample.app.compose.ui.features.home

import androidx.lifecycle.viewModelScope
import com.kasia.sample.app.compose.base.BaseViewModel
import com.kasia.sample.app.domain.models.Item
import com.kasia.sample.app.domain.usecases.FetchAndSaveDataUseCase
import com.kasia.sample.app.domain.usecases.LoadLocalDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchAndSaveDataUseCase: FetchAndSaveDataUseCase,
    private val loadLocalDataUseCase: LoadLocalDataUseCase
) : BaseViewModel() {

    private var _photosList = MutableStateFlow(listOf<Item>())
    val photosList: Flow<List<Item>> = _photosList

    init {
        loadLocalData()
        refreshData()
    }

    private fun loadLocalData(){
        viewModelScope.launch(Dispatchers.IO) {
            loadLocalDataUseCase.execute().collect {
                _photosList.emit(it)
            }
        }
    }

    private fun refreshData() {
        launch {
            fetchAndSaveDataUseCase.execute()
        }
    }
}