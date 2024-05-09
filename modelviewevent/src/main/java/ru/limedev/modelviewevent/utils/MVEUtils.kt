package ru.limedev.modelviewevent.utils

import ru.limedev.modelviewevent.base.BaseViewEvent
import ru.limedev.modelviewevent.base.BaseViewState
import ru.limedev.modelviewevent.ui.MVEUserInterface
import ru.limedev.modelviewevent.viewmodel.MVEViewModel
import ru.limedev.modelviewevent.viewmodel.MVECustomViewModel

/**
 * Changes the current ViewState. Use this function only if you want to change the ViewState
 * outside of [MVEViewModel] or [MVECustomViewModel].
 * @see BaseViewEvent
 * @see BaseViewState
 */
fun <E: BaseViewEvent, S: BaseViewState> MVEViewModel<E>.setState(viewState: S) = setViewState(viewState)

/**
 * Used to send ViewEvent to ViewModel. Use this function only if you want to send ViewEvent
 * to ViewModel outside of [MVEUserInterface].
 */
fun <E: BaseViewEvent> MVEUserInterface<E>.triggerEvent(viewEvent: E) = triggerViewEvent(viewEvent)