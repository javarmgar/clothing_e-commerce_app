package com.clothingapp.core.data.repository

import com.clothingapp.core.data.remote.model.HiringResponseModel
import com.clothingapp.core.data.remote.model.params.HiringParamsModel

interface HiringRepository {

    suspend fun getHiringList(hiringParamsModel: HiringParamsModel): List<HiringResponseModel>

}