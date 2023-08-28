package com.clothingapp.core.data.remote.datasource

import com.clothingapp.core.data.remote.base.RemoteDataSource
import com.clothingapp.core.data.remote.model.HiringResponseModel
import com.clothingapp.core.data.remote.model.params.HiringParamsModel

interface HiringRemoteDataSource: RemoteDataSource {
    suspend fun getHiringResponseModel(hiringParamsModel: HiringParamsModel): List<HiringResponseModel>

}