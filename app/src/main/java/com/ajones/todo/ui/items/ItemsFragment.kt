package com.ajones.todo.ui.items

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ajones.todo.R

class ItemsFragment : Fragment(R.layout.items_fragment) {

    companion object {
        fun newInstance() = ItemsFragment()
    }

    private val viewModel: ItemsViewModel by viewModels()

    private lateinit var progressBar: ProgressBar
    private lateinit var message: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressBar = view.findViewById(R.id.progress_indicator)
        message = view.findViewById(R.id.message)

        viewModel.uiState.observe(viewLifecycleOwner) { state ->
            when (state) {
                Initializing -> {
                    progressBar.visibility = View.VISIBLE
                    message.visibility = View.GONE
                }
                is ReadyState -> {
                    progressBar.visibility = View.GONE
                    message.visibility = View.VISIBLE
                }
                is FailedState -> {
                    progressBar.visibility = View.GONE
                    message.visibility = View.VISIBLE
                    message.text = "Failed to Load"
                }
            }
        }
    }
}