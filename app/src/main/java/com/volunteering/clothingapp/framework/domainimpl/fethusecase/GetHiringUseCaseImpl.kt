package com.volunteering.clothingapp.framework.domainimpl.fethusecase

import android.util.Log
import com.clothingapp.core.data.remote.model.HiringResponseModel
import com.clothingapp.core.data.remote.model.params.HiringParamsModel
import com.clothingapp.core.data.repository.HiringRepository
import com.clothingapp.core.domain.fetchusecase.GetHiringUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetHiringUseCaseImpl @Inject constructor(
    override val hiringRepository: HiringRepository
): GetHiringUseCase {

    private val LOG_TAG = "LT_GetHiringUseCase"

    override suspend fun invoke(hiringParamsModel: HiringParamsModel): List<HiringResponseModel> {
        Log.d(LOG_TAG, "invoke()  STEP 1:")
        return (hiringRepository.getHiringList(hiringParamsModel)).also {
            Log.d(LOG_TAG, "invoke()  STEP 2: menuRepository.getHiringList() return with  result:$it")
        }
    }

}