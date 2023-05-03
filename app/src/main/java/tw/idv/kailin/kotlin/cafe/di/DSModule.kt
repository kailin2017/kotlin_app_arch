package tw.idv.kailin.kotlin.cafe.di

import tw.idv.kailin.kotlin.cafe.repo.cafe.CafeApiSource
import tw.idv.kailin.kotlin.cafe.repo.cafe.CafeApiSourceImpl
import tw.idv.kailin.kotlin.cafe.repo.cafe.CafeDaoSource
import tw.idv.kailin.kotlin.cafe.repo.cafe.CafeDaoSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DSModule {

    @Binds
    abstract fun cafeApiSource(source: CafeApiSourceImpl): CafeApiSource

    @Binds
    abstract fun cafeDaoSource(source: CafeDaoSourceImpl): CafeDaoSource
}