package com.ajones.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ajones.todo.ui.feature.studycards.StudyCardsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, StudyCardsFragment.newInstance())
                .commitNow()
        }
    }
}