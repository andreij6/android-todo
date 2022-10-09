package com.ajones.todo.domain.studycards.models

import com.ajones.todo.data.StudyCardData

data class StudyCardsDomain(
    val question: String,
    val answer: String
) {
    companion object {
        fun mapper(dataModel: StudyCardData): StudyCardsDomain {
            return StudyCardsDomain(
                question = dataModel.question,
                answer = dataModel.answer
            )
        }
    }
}

