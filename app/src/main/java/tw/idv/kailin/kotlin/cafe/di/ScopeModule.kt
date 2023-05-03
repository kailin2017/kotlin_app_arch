package tw.idv.kailin.kotlin.cafe.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ScopeModule {

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class IOJob

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class IOScope

    @IOJob
    @Singleton
    @Provides
    fun providerIOJob(): Job = SupervisorJob()

    @IOScope
    @Singleton
    @Provides
    fun providerIOScope(@IOJob job: Job): CoroutineScope = CoroutineScope(Dispatchers.IO + job)
}