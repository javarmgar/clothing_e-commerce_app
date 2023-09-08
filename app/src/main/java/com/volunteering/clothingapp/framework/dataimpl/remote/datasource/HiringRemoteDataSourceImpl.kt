package com.volunteering.clothingapp.framework.dataimpl.remote.datasource

import android.util.Log
import com.clothingapp.core.data.remote.datasource.HiringRemoteDataSource
import com.clothingapp.core.data.remote.model.HiringResponseModel
import com.clothingapp.core.data.remote.model.params.HiringParamsModel
import com.volunteering.clothingapp.framework.dataimpl.remote.api.service.FetchServiceDef
import com.volunteering.clothingapp.framework.dataimpl.remote.model.response.HiringResponse
import com.volunteering.clothingapp.framework.dataimpl.mapper.HiringMapperImpl
import com.volunteering.clothingapp.framework.library.key.KeysRemote
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HiringRemoteDataSourceImpl @Inject constructor(
    private val fetchServiceDef: FetchServiceDef,
    private val keysRemote: KeysRemote,
): HiringRemoteDataSource {

    private val LOG_TAG:String = "LT_HiringRemoteDS"
    override suspend fun getHiringResponseModel(hiringParamsModel: HiringParamsModel): List<HiringResponseModel> {
        Log.d(LOG_TAG,"-> getHiringResponseModel() ")
        var hiringResponseModelList: List<HiringResponseModel>
        hiringParamsModel.apply {
            val hiringResponse: Response<List<HiringResponse>> = fetchServiceDef.getHiringList()
            if(hiringResponse.isSuccessful  && hiringResponse.body() != null){
                Log.d(LOG_TAG,"-> getHiringResponseModel() isSuccessFullAndNotNull response:${hiringResponse.body()}")
                hiringResponseModelList = hiringResponse.body()!!.map { hiringResponseItem ->
                    HiringMapperImpl().map(hiringResponseItem)
                }
                return hiringResponseModelList
            }else{
                Log.d(LOG_TAG,"-> getHiringResponseModel() NOT isSuccessFullAndNotNull response:${hiringResponse.errorBody()}")
                throw Exception("failure to connect service : ${hiringResponse.errorBody()}")
            }
        }
    }

}