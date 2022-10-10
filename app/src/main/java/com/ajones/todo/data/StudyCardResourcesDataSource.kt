package com.ajones.todo.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class StudyCardResourcesDataSource : StudyCardRepository {

    override val studyCards: Flow<List<StudyCardData>> = flow {
        emit(
            listOf(
                StudyCardData(
                    question = "What is context?",
                    answer = "The cnotext in Android is the context of the current state of the application or object. The context comes with services like giving access to databases and preferences, resolving resources and more"
                ),
                StudyCardData(
                    question = "What is shared storage?",
                    answer = "Stores files that your app intends to share with other apps, including media documents and other files"
                ),
                StudyCardData(
                    question = "What are Services in Android?",
                    answer = "Android service is a component that is used to perform operations on the background such as playing music, handle network transactions, interacting content providers etc. It doesn't has any UI (user interface). The service runs in the background indefinitely even if application is destroyed."
                )
            )
        )
    }

}