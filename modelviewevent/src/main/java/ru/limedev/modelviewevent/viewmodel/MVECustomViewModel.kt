package ru.limedev.modelviewevent.viewmodel

import androidx.lifecycle.LiveData
import ru.limedev.modelviewevent.base.BaseViewEvent
import ru.limedev.modelviewevent.base.BaseViewModel
import ru.limedev.modelviewevent.base.BaseViewState
import ru.limedev.modelviewevent.lifecycle.SingleLiveEvent

/**
 * This class must be the parent of your custom ViewModels if you are implementing the Model
 * View Event approach.
 *
 * The meaning of the custom ViewModels means ViewModels that don't use [androidx.lifecycle.ViewModel].
 * @see [BaseViewModel]
 */
abstract class MVECustomViewModel<E: BaseViewEvent> : BaseViewModel {

    /**
     * Current ViewState.
     *
     * Pay attention that ViewState is an [SingleLiveEvent], which prevents the re-arrival of a
     * new state when the configuration changes, for example when the screen is rotated.
     * @see [SingleLiveEvent]
     * @see [BaseViewState]
     */
    private val _viewState = SingleLiveEvent<BaseViewState>()

    /**
     * Used to listen to ViewEvents coming from the UI.
     * @see [BaseViewEvent]
     */
    abstract fun onTriggerEvent(viewEvent: E)

    /**
     * Returns the current ViewState.
     * @see [BaseViewState]
     */
    fun getViewState(): LiveData<BaseViewState> = _viewState

    /**
     * Changes the current ViewState.
     * @see [BaseViewState]
     */
    fun <S: BaseViewState> setViewState(viewState: S) { _viewState.value = viewState }
}