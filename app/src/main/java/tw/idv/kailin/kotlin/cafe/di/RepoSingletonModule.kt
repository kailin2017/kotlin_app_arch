package tw.idv.kailin.kotlin.cafe.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tw.idv.kailin.kotlin.cafe.repo.global.GlobalRepo
import tw.idv.kailin.kotlin.cafe.repo.global.GlobalRepoImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoSingletonModule {

    @Singleton
    @Binds
    abstract fun globalRepo(globalRepoImpl: GlobalRepoImpl): GlobalRepo
}