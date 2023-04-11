package com.kailin.kotlin_app_arch.di

import com.kailin.kotlin_app_arch.repo.ds.CafeApiSource
import com.kailin.kotlin_app_arch.repo.ds.CafeApiSourceImpl
import com.kailin.kotlin_app_arch.repo.ds.CafeDaoSource
import com.kailin.kotlin_app_arch.repo.ds.CafeDaoSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DSModule {

    @Binds
    abstract fun provideCafeApiSource(source: CafeApiSourceImpl): CafeApiSource

    @Binds
    abstract fun provideCafeDaoSource(source: CafeDaoSourceImpl): CafeDaoSource
}