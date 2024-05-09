package ru.limedev.sample.presentation.main.fragment.mve

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.limedev.modelviewevent.ui.MVEUserInterface
import ru.limedev.sample.presentation.main.viewevent.MainViewEvent
import ru.limedev.sample.presentation.main.viewmodel.MainViewModel
import ru.limedev.sample.presentation.main.viewstate.MainViewState

abstract class MVEMainFragment : Fragment(), MVEUserInterface<MainViewEvent> {

    private val mainViewModel: MainViewModel by viewModels()

    abstract fun onLoadingState()

    abstract fun onSuccessState(data: String)

    abstract fun onErrorState(data: String)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeStates()
    }

    override fun triggerViewEvent(viewEvent: MainViewEvent) = mainViewModel.onTriggerEvent(viewEvent)

    override fun observeStates() {
        mainViewModel.getViewState().observe(viewLifecycleOwner) { state ->
            when (state) {
                is MainViewState.LoadingState -> onLoadingState()
                is MainViewState.SuccessState -> onSuccessState(state.data)
                is MainViewState.ErrorState -> onErrorState(state.data)
            }
        }
    }
}