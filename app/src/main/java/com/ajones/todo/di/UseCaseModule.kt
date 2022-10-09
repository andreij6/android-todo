package com.ajones.todo.di

import com.ajones.todo.data.StudyCardRepository
import com.ajones.todo.domain.studycards.usecase.GetStudyCards
import com.ajones.todo.domain.studycards.usecase.GetStudyCardsImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetStudyCards(repository: StudyCardRepository): GetStudyCards {
        return GetStudyCardsImpl(repository)
    }

}