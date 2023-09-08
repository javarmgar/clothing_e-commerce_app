package com.volunteering.clothingapp.framework.domainimpl.base

import com.clothingapp.core.domain.fetchusecase.GetHiringUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Interactors @Inject constructor(
    val getHiringUseCase: GetHiringUseCase,
)