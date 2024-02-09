package com.kasia.sample.app.compose.ui.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kasia.sample.app.domain.usecases.GetAllPhotosUseCase
import com.kasia.sample.app.domain.usecases.RefreshPhotosDataUseCase
import com.kasia.sample.app.storage.db.ItemModel
import com.kasia.sample.app.storage.usecase.GetAllPhotosUseCaseImpl
import com.kasia.sample.app.storage.usecase.RefreshPhotosDataUseCaseImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllPhotosUseCase: GetAllPhotosUseCase, //should use GetAllPhotosUseCaseImpl or GetAllPhotosUseCase? => GetAllPhotosUseCase is in domain, so shouldnt be used by UI
    private val refreshPhotosDataUseCaseImpl: RefreshPhotosDataUseCase
) : ViewModel() {

    val photosList by lazy {
        getAllPhotosUseCase.execute().map { it.map { ItemModel.fromItem(it) } } //todo
    }

    init {
        refreshData()
    }

    private fun refreshData() {
        viewModelScope.launch(Dispatchers.IO) {
            refreshPhotosDataUseCaseImpl.execute()
        }
    }
}