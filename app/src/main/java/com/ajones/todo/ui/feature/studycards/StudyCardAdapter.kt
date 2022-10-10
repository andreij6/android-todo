package com.ajones.todo.ui.feature.studycards

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ajones.todo.R

class StudyCardAdapter : RecyclerView.Adapter<StudyCardAdapter.ViewHolder>() {

    private var cards: List<StudyCardUi> = emptyList()

    fun setCards(list: List<StudyCardUi>){
        cards = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.study_adapter_item, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val card = cards[position]
        holder.questionTextView.text = card.question
        holder.answerTextView.text = card.answer
    }

    override fun getItemCount(): Int = cards.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val questionTextView: TextView = view.findViewById(R.id.study_adapter_item_question)
        val answerTextView: TextView = view.findViewById(R.id.study_adapter_item_answer)
    }
}