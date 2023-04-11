package tw.idv.kailin.kotlin.cafe.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import tw.idv.kailin.kotlin.cafe.model.CafeNomad

@Database(entities = [CafeNomad::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cafeDao(): CafeDao
}