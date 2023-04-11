package tw.idv.kailin.kotlin.cafe.di

import tw.idv.kailin.kotlin.cafe.repo.ds.CafeApiSource
import tw.idv.kailin.kotlin.cafe.repo.ds.CafeApiSourceImpl
import tw.idv.kailin.kotlin.cafe.repo.ds.CafeDaoSource
import tw.idv.kailin.kotlin.cafe.repo.ds.CafeDaoSourceImpl
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