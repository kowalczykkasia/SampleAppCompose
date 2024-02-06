package com.kasia.sample.app.compose.ui.features.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kasia.sample.app.storage.usecases.GetAllPhotosUseCaseImpl
import com.kasia.sample.app.storage.usecases.RefreshPhotosDataUseCaseImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllPhotosUseCase: GetAllPhotosUseCaseImpl,
    private val refreshPhotosDataUseCaseImpl: RefreshPhotosDataUseCaseImpl
) : ViewModel() {

    val photosList by lazy {
        getAllPhotosUseCase.execute()
    }

    init {
        viewModelScope.launch(Dispatchers.IO) {
            refreshPhotosDataUseCaseImpl.execute()
        }
    }
}