package ru.limedev.sample.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.limedev.sample.R
import ru.limedev.sample.presentation.main.fragment.regular.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createSampleFragment(savedInstanceState)
    }

    private fun createSampleFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) return
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MainFragment.newInstance())
            .commitNow()
    }
}