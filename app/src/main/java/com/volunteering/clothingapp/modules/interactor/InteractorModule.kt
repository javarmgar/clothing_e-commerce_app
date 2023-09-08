package com.volunteering.clothingapp.modules.interactor

import com.clothingapp.core.domain.fetchusecase.GetHiringUseCase
import com.volunteering.clothingapp.framework.domainimpl.fethusecase.GetHiringUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class InteractorModule {

    @Binds
    abstract fun bindGetHiringUseCase( getHiringUseCaseImpl: GetHiringUseCaseImpl): GetHiringUseCase

}