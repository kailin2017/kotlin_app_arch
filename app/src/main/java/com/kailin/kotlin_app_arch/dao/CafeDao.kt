package com.kailin.kotlin_app_arch.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kailin.kotlin_app_arch.model.CafeNomad
import kotlinx.coroutines.flow.Flow

@Dao
interface CafeDao {

    @Query("select count(*) from CafeNomad")
    fun getCount(): Int

    @Query("select * from CafeNomad")
    fun getFlow(): Flow<List<CafeNomad>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg cafeNomad: CafeNomad)
}