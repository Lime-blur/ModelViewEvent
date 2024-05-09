package ru.limedev.sample.presentation.main.viewevent

import ru.limedev.modelviewevent.base.BaseViewEvent

sealed class MainViewEvent : BaseViewEvent {

    data object RequestData : MainViewEvent()
}