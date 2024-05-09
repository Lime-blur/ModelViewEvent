package ru.limedev.sample.presentation.main.viewmodel

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.limedev.modelviewevent.viewmodel.MVEViewModel
import ru.limedev.sample.presentation.main.viewevent.MainViewEvent
import ru.limedev.sample.presentation.main.viewstate.MainViewState

class MainViewModel : MVEViewModel<MainViewEvent>() {

    override fun onTriggerEvent(viewEvent: MainViewEvent) {
        when (viewEvent) {
            is MainViewEvent.RequestData -> handleDataRequest()
        }
    }

    private fun handleDataRequest() {
        setViewState(MainViewState.LoadingState)
        viewModelScope.launch {
            delay(2000)
            setViewState(getStateFromResponse())
        }
    }

    private fun getStateFromResponse(): MainViewState {
        val success = isSuccessResponse()
        return if (success) {
            MainViewState.SuccessState("Success!")
        } else {
            MainViewState.ErrorState("Error!")
        }
    }

    private fun isSuccessResponse(): Boolean {
        val currentTime = System.currentTimeMillis().toInt()
        return currentTime % 2 == 0
    }
}