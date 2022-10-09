package com.ajones.todo.data

import kotlinx.coroutines.flow.Flow

interface StudyCardRepository {
    val studyCards: Flow<List<StudyCardData>>
}

