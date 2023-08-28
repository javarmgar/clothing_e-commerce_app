package com.volunteering.clothingapp.modules.datasource.remote

import com.clothingapp.core.data.remote.datasource.HiringRemoteDataSource
import com.volunteering.clothingapp.framework.dataimpl.remote.datasource.HiringRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    @Binds
    abstract fun bindHiringRemoteDataSource(hiringRemoteDataSourceImpl: HiringRemoteDataSourceImpl): HiringRemoteDataSource

}