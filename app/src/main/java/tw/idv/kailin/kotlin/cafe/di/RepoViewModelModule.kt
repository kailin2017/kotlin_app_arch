package tw.idv.kailin.kotlin.cafe.di

import tw.idv.kailin.kotlin.cafe.repo.cafe.CafeRepo
import tw.idv.kailin.kotlin.cafe.repo.cafe.CafeRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepoViewModelModule {

    @Binds
    abstract fun cafeRepo(repository: CafeRepoImpl): CafeRepo
}

