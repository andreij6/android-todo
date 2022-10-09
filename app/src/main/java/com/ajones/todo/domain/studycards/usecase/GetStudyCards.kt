package com.ajones.todo.domain.studycards.usecase

import com.ajones.todo.data.StudyCardRepository
import com.ajones.todo.domain.studycards.models.StudyCardsDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

interface GetStudyCards {
    operator fun invoke(): Flow<List<StudyCardsDomain>>
}

class GetStudyCardsImpl(
    private val repository: StudyCardRepository
) : GetStudyCards {

    override operator fun invoke(): Flow<List<StudyCardsDomain>> {
        return repository.studyCards.map { list ->
            list.map{ StudyCardsDomain.mapper(it) }
        }
    }
}

