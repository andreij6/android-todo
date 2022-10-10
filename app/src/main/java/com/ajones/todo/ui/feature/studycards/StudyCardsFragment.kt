package com.ajones.todo.ui.feature.studycards

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ajones.todo.R
import com.ajones.todo.StudyCardApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StudyCardsFragment : Fragment(R.layout.study_cards_fragment) {

    companion object {
        fun newInstance() = StudyCardsFragment()
    }

    private val viewModel: StudyCardsViewModel by viewModels()

    private lateinit var progressBar: ProgressBar
    private lateinit var recycler: RecyclerView
    private lateinit var message: TextView
    private var studyCardAdapter = StudyCardAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressBar = view.findViewById(R.id.study_cards_fragment_progress_indicator)
        recycler = view.findViewById(R.id.study_cards_fragment_recycler)
        message = view.findViewById(R.id.study_cards_fragment_message)
        recycler.layoutManager = LinearLayoutManager(view.context)
        recycler.adapter = studyCardAdapter

        viewModel.uiState.observe(viewLifecycleOwner) { state ->
            when (state) {
                Initializing -> {
                    progressBar.visibility = View.VISIBLE
                    recycler.visibility = View.GONE
                    message.visibility = View.GONE
                }
                is ReadyState -> {
                    progressBar.visibility = View.GONE
                    message.visibility = View.GONE
                    studyCardAdapter.setCards(state.cards)
                    recycler.visibility = View.VISIBLE
                }
                is FailedState -> {
                    progressBar.visibility = View.GONE
                    recycler.visibility = View.GONE
                    message.visibility = View.VISIBLE
                    message.text = "Failed to Load"
                }
            }
        }
    }
}