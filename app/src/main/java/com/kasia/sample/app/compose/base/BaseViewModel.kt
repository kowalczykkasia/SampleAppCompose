package com.kasia.sample.app.compose.base

import androidx.lifecycle.ViewModel
import com.kasia.sample.app.domain.models.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : ViewModel(), CoroutineScope {

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private val _error = MutableSharedFlow<Exception>()
    val error: SharedFlow<Exception>
        get() = _error

    override fun onCleared() {
        job.cancel()
    }

    fun <T> launch(action: suspend () -> Result<T>) {
        launch(Dispatchers.IO) {
            val response = action.invoke()
            if(response is Result.Error) _error.emit(response.error)
        }
    }
}