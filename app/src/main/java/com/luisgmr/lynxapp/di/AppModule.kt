package com.luisgmr.lynxapp.di

import com.luisgmr.lynxapp.data.repository.StudentRepository
import com.luisgmr.lynxapp.data.repository.SubjectRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideStudentRepository(): StudentRepository {
        return StudentRepository()
    }

    @Provides
    @Singleton
    fun provideSubjectRepository(): SubjectRepository {
        return SubjectRepository()
    }

}