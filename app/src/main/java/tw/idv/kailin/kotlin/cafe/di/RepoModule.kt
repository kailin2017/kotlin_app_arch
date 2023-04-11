package tw.idv.kailin.kotlin.cafe.di

import tw.idv.kailin.kotlin.cafe.repo.CafeRepo
import tw.idv.kailin.kotlin.cafe.repo.CafeRepoImpl
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