package tw.idv.kailin.kotlin.cafe.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tw.idv.kailin.kotlin.cafe.repo.CafeRepo
import tw.idv.kailin.kotlin.cafe.repo.CafeRepoImpl
import tw.idv.kailin.kotlin.cafe.repo.ds.CafeApiSource
import tw.idv.kailin.kotlin.cafe.repo.ds.CafeApiSourceFake
import tw.idv.kailin.kotlin.cafe.repo.ds.CafeDaoSource
import tw.idv.kailin.kotlin.cafe.repo.ds.CafeDaoSourceFake
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CafeRepoModule {

    @Singleton
    @Binds
    abstract fun provideCafeApiSource(source: CafeApiSourceFake): CafeApiSource

    @Singleton
    @Binds
    abstract fun provideCafeDaoSource(source: CafeDaoSourceFake): CafeDaoSource

    @Singleton
    @Binds
    abstract fun provideCafeRepo(source: CafeRepoImpl): CafeRepo
}