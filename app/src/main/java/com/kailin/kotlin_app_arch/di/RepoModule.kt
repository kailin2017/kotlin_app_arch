package com.kailin.kotlin_app_arch.di

import com.kailin.kotlin_app_arch.repo.CafeRepo
import com.kailin.kotlin_app_arch.repo.CafeRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepoModule {

    @Binds
    abstract fun provideCafeRepo(repository: CafeRepoImpl): CafeRepo
}