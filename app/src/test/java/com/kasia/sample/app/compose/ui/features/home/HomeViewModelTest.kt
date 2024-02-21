package com.kasia.sample.app.compose.ui.features.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.times
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import com.google.common.truth.Truth.assertThat
import com.kasia.sample.app.domain.models.Item
import com.kasia.sample.app.domain.usecases.FetchAndSaveDataUseCase
import com.kasia.sample.app.domain.usecases.LoadLocalDataUseCase
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
    private lateinit var fetchAndSaveDataUseCase: FetchAndSaveDataUseCase
    @Mock
    private lateinit var loadLocalDataUseCase: LoadLocalDataUseCase

    private lateinit var viewModel: HomeViewModel

    @Before
    fun setUp() = runBlocking {
        fetchAndSaveDataUseCase = mock()
        loadLocalDataUseCase = mock()
        viewModel = HomeViewModel(fetchAndSaveDataUseCase, loadLocalDataUseCase)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `on getPhotosList should load all photos`() = runTest {
        whenever(loadLocalDataUseCase.execute()).thenReturn(flowOf(ALL_PHOTOS))
        viewModel.photosList.collect {
            assertThat(it).isEqualTo(ALL_PHOTOS)
        }
        verify(loadLocalDataUseCase, times(1)).execute()
    }

    @Test
    fun `init block should call refreshData`() = runTest {
        verify(fetchAndSaveDataUseCase, times(1)).execute()
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