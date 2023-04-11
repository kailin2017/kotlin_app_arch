package com.kailin.kotlin_app_arch.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kailin.kotlin_app_arch.model.CafeNomad

@Database(entities = [CafeNomad::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cafeDao(): CafeDao
}