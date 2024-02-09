package com.kasia.sample.app.compose.ui.features.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.times
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import com.google.common.truth.Truth.assertThat
import com.kasia.sample.app.domain.models.Item
import com.kasia.sample.app.domain.usecases.GetAllPhotosUseCase
import com.kasia.sample.app.domain.usecases.RefreshPhotosDataUseCase
import com.kasia.sample.app.storage.db.ItemModel
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule

class HomeViewModelTest {


    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var refreshPhotosDataUseCase: com.kasia.sample.app.domain.usecases.RefreshPhotosDataUseCase
    @Mock
    private lateinit var getAllPhotosUseCase: com.kasia.sample.app.domain.usecases.GetAllPhotosUseCase

    private lateinit var viewModel: HomeViewModel

    @Before
    fun setUp() = runBlocking {
        refreshPhotosDataUseCase = mock()
        getAllPhotosUseCase = mock()
        viewModel = HomeViewModel(getAllPhotosUseCase, refreshPhotosDataUseCase)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `on getPhotosList should load all photos`() = runTest {
        whenever(getAllPhotosUseCase.execute()).thenReturn(flowOf(ALL_PHOTOS))
        viewModel.photosList.collect {
            assertThat(it).isEqualTo(ALL_PHOTOS)
        }
        verify(getAllPhotosUseCase, times(1)).execute()
    }

    @Test
    fun `init block should call refreshData`() = runTest {
        verify(refreshPhotosDataUseCase, times(1)).execute()
    }

    companion object {
        val ALL_PHOTOS =  listOf(
            Item(
                "createdAt", 0, "0", "name", "subId", "url", 0
            ),
            Item(
                "createdAt", 0, "1", "name", "subId", "url", 0
            )
        )
    }
}