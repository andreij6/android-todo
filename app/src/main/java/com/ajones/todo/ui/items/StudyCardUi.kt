package com.ajones.todo.ui.items

import com.ajones.todo.domain.studycards.models.StudyCardsDomain

data class StudyCardUi(
    val question: String,
    val answer: String
) {
    companion object {
        fun mapper(domanModel: StudyCardsDomain) : StudyCardUi {
            return StudyCardUi(
                question = domanModel.question,
                answer = domanModel.answer
            )
        }
    }
}
