package ru.limedev.sample.presentation.main.fragment.regular

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import ru.limedev.sample.databinding.FragmentMainBinding
import ru.limedev.sample.presentation.main.fragment.mve.MVEMainFragment
import ru.limedev.sample.presentation.main.viewevent.MainViewEvent

class MainFragment : MVEMainFragment() {

    private var binding: FragmentMainBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        state: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return requireNotNull(binding).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        triggerViewEvent(MainViewEvent.RequestData)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    override fun onLoadingState() {
        binding?.tvResult?.isVisible = false
        binding?.pbLoading?.isVisible = true
    }

    override fun onSuccessState(data: String) {
        binding?.pbLoading?.isVisible = false
        binding?.tvResult?.text = data
        binding?.tvResult?.isVisible = true
    }

    override fun onErrorState(data: String) {
        binding?.pbLoading?.isVisible = false
        binding?.tvResult?.text = data
        binding?.tvResult?.isVisible = true
    }

    companion object {

        @JvmStatic
        fun newInstance() = MainFragment()
    }
}