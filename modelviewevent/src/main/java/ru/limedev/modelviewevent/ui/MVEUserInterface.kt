package ru.limedev.modelviewevent.ui

import androidx.lifecycle.ViewModel
import ru.limedev.modelviewevent.base.BaseViewEvent
import ru.limedev.modelviewevent.base.BaseViewState

/**
 * This interface must be implemented by your MVE UserInterfaces if you are implementing the Model
 * View Event approach.
 *
 * MVE UserInterfaces are parent abstract activities / fragments for regular activities / fragments that
 * listen to ViewStates and call abstract functions for each state. In addition, MVE UserInterfaces
 * must handle sending ViewEvents to the ViewModel.
 * @see [ViewModel]
 * @see [BaseViewEvent]
 * @see [BaseViewState]
 */
interface MVEUserInterface <E: BaseViewEvent> {

    /**
     * Used to send ViewEvent to ViewModel.
     */
    fun triggerViewEvent(viewEvent: E)

    /**
     * Used to listen to ViewStates coming from ViewModel.
     */
    fun observeStates()
}