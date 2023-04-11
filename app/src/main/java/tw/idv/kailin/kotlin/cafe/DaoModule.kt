package tw.idv.kailin.kotlin.cafe

import android.content.Context
import androidx.room.Room
import tw.idv.kailin.kotlin.cafe.dao.AppDatabase
import tw.idv.kailin.kotlin.cafe.dao.CafeDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class AppDB

    @AppDB
    @Singleton
    @Provides
    fun provideAppDB(@ApplicationContext context: Context): AppDatabase = Room.databaseBuilder(
        context, AppDatabase::class.java, "AppDB"
    ).build()

    @Singleton
    @Provides
    fun provideCafeDao(@AppDB db: AppDatabase): CafeDao = db.cafeDao()
}