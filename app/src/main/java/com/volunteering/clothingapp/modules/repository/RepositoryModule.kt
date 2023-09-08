package com.volunteering.clothingapp.modules.repository

import com.clothingapp.core.data.repository.HiringRepository
import com.volunteering.clothingapp.framework.dataimpl.repository.HiringRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindHiringRepository(hiringRepositoryImpl: HiringRepositoryImpl): HiringRepository

}