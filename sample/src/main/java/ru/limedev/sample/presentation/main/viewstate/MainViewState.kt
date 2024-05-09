package ru.limedev.sample.presentation.main.viewstate

import ru.limedev.modelviewevent.base.BaseViewState

sealed class MainViewState : BaseViewState {

    data object LoadingState : MainViewState()

    data class SuccessState(val data: String) : MainViewState()

    data class ErrorState(val data: String) : MainViewState()
}