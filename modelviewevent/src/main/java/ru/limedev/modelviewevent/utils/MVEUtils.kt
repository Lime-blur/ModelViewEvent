package ru.limedev.modelviewevent.utils

import ru.limedev.modelviewevent.base.BaseViewEvent
import ru.limedev.modelviewevent.base.BaseViewState
import ru.limedev.modelviewevent.ui.MVEUserInterface
import ru.limedev.modelviewevent.viewmodel.MVEViewModel
import ru.limedev.modelviewevent.viewmodel.MVECustomViewModel

/**
 * Changes the current ViewState. This is a shortened variant of calling method
 * [MVECustomViewModel.setViewState].
 * @see BaseViewEvent
 * @see BaseViewState
 */
fun <E: BaseViewEvent, S: BaseViewState> MVEViewModel<E>.setState(viewState: S) = setViewState(viewState)

/**
 * Used to send ViewEvent to ViewModel. This is a shortened variant of calling method
 * [MVEUserInterface.triggerViewEvent].
 */
fun <E: BaseViewEvent> MVEUserInterface<E>.triggerEvent(viewEvent: E) = triggerViewEvent(viewEvent)