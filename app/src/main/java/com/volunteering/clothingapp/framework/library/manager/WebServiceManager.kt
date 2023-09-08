package com.volunteering.clothingapp.framework.library.manager

import android.util.Log
import com.clothingapp.core.data.remote.base.ServiceDefinition
import com.volunteering.clothingapp.framework.dataimpl.remote.conf.ServiceFactory
import okhttp3.Headers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WebServiceManager @Inject constructor(){
    private val LOG_TAG: String = "LWebServiceManager"

    fun <T: ServiceDefinition> getWebService(
        isDebug: Boolean,
        baseUrl: String,
        headers: Headers,
        serviceClass: Class<T>,
    ): T {
        Log.d(LOG_TAG,"-> getWebService() ")

        val serviceFactory = ServiceFactory.Builder().run {
            isDebug(isDebug)
            baseUrl(baseUrl)
            headers(headers)
            build()
        }
        return serviceFactory.create(serviceClass)
    }
}