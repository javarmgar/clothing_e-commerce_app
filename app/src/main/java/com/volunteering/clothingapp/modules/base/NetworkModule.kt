package com.volunteering.clothingapp.modules.base

import com.volunteering.clothingapp.framework.dataimpl.remote.api.service.FetchServiceDef
import com.volunteering.clothingapp.framework.dataimpl.remote.conf.HeadersEmpty
import com.volunteering.clothingapp.framework.library.manager.EnvironmentManager
import com.volunteering.clothingapp.framework.library.manager.WebServiceManager
import com.volunteering.clothingapp.framework.library.key.KeysRemote
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import okhttp3.Headers

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private val LOG_TAG: String = "LT_NetworkModule"

    @Provides
    @Singleton
    fun provideFetchService(
        webServiceManager: WebServiceManager,
        environmentManager: EnvironmentManager,
        keysRemote: KeysRemote,
        @HeadersEmpty headers: Headers
    ): FetchServiceDef = webServiceManager.getWebService(
        environmentManager.isDebug,
        keysRemote.BASE_URL_FETCH,
        headers,
        FetchServiceDef::class.java
    )
}