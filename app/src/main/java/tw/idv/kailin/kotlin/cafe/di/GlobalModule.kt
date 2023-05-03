package tw.idv.kailin.kotlin.cafe.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tw.idv.kailin.kotlin.cafe.util.connect.ConnectManager
import tw.idv.kailin.kotlin.cafe.util.connect.ConnectManagerImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class GlobalModule {

    @Singleton
    @Binds
    abstract fun connectManager(connectManagerImpl: ConnectManagerImpl): ConnectManager
}