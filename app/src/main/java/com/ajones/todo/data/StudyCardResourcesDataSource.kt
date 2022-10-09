package com.ajones.todo.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class StudyCardResourcesDataSource : StudyCardRepository {

    override val studyCards: Flow<List<StudyCardData>> = flow {
        emit(
            listOf(
                StudyCardData(
                    question = "q 1",
                    answer = "a 1"
                ),
                StudyCardData(
                    question = "q 2",
                    answer = "a 2"
                ),
                StudyCardData(
                    question = "q 3",
                    answer = "a 3"
                )
            )
        )
    }

}