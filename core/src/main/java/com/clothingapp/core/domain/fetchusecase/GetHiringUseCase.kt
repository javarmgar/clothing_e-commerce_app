package com.clothingapp.core.domain.fetchusecase

import com.clothingapp.core.data.remote.model.HiringResponseModel
import com.clothingapp.core.data.remote.model.params.HiringParamsModel
import com.clothingapp.core.data.repository.HiringRepository

interface GetHiringUseCase {

    val hiringRepository: HiringRepository

    suspend operator fun invoke(hiringParamsModel: HiringParamsModel): List<HiringResponseModel>

}