package tw.idv.kailin.kotlin.cafe.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import tw.idv.kailin.kotlin.cafe.model.CafeNomad
import kotlinx.coroutines.flow.Flow

@Dao
interface CafeDao {

    @Query("SELECT COUNT(*) FROM CafeNomad")
    fun getCafeCount(): Flow<Int>

    @Query("SELECT * FROM CafeNomad")
    fun getCafes(): Flow<List<CafeNomad>>

    @Query("SELECT * FROM CafeNomad WHERE city IN(:cities)")
    fun getCafes(vararg cities: String): Flow<List<CafeNomad>>

    @Query("SELECT DISTINCT city FROM CafeNomad")
    fun getCities(): Flow<List<String>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg cafeNomad: CafeNomad)
}