package tw.idv.kailin.kotlin.cafe.repo.ds

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import tw.idv.kailin.kotlin.cafe.model.CafeNomad
import java.util.*
import javax.inject.Inject
import kotlin.random.Random

class CafeDaoSourceFake @Inject constructor(): CafeDaoSource {
    private val citiesList = listOf("Taipei", "Taichung", "Tainan", "Kaohsiung")
    private val cafeList = MutableList(10) {
        val uuid = UUID.randomUUID().toString()
        CafeNomad(
            uuid,
            "$uuid Cafe",
            5f,
            5f,
            5f,
            5f,
            5f,
            5f,
            "$uuid Cafe",
            "0",
            "0",
            "https://www.google.com",
            "",
            "",
            "",
            citiesList[Random.nextInt(0, citiesList.size)],
            "",
            ""
        )
    }
    override val cafeCount: Flow<Int> = flow { emit(10) }
    override val cafes: Flow<List<CafeNomad>> = flow { emit(cafeList) }
    override val cities: Flow<List<String>> = flow { emit(citiesList) }

    override suspend fun insert(vararg cafeNomad: CafeNomad) {
    }

    override fun cafes(vararg cities: String): Flow<List<CafeNomad>> =
        flow { emit(cafeList.filter { cities.contains(it.city) }) }

    override fun cities(): Flow<List<String>> = flow { emit(listOf()) }
}