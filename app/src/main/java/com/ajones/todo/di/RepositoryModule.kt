package com.ajones.todo.di

import com.ajones.todo.data.StudyCardRepository
import com.ajones.todo.data.StudyCardResourcesDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideStudyCardRepository(): StudyCardRepository {
        return StudyCardResourcesDataSource()
    }

}