package com.kasia.sample.app.compose.ui.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kasia.sample.app.storage.usecases.GetAllPhotosUseCase
import com.kasia.sample.app.storage.usecases.RefreshPhotosDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllPhotosUseCase: GetAllPhotosUseCase,
    private val refreshPhotosDataUseCaseImpl: RefreshPhotosDataUseCase
) : ViewModel() {

    val photosList by lazy {
        getAllPhotosUseCase.execute()
    }

    init {
        refreshData()
    }

    private fun refreshData(){
        viewModelScope.launch(Dispatchers.IO) {
            refreshPhotosDataUseCaseImpl.execute()
        }
    }
}