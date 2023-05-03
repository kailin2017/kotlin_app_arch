package tw.idv.kailin.kotlin.cafe.repo.ds

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import tw.idv.kailin.kotlin.cafe.model.CafeNomad
import tw.idv.kailin.kotlin.cafe.repo.cafe.CafeDaoSource
import java.util.*
import javax.inject.Inject
import kotlin.random.Random

class CafeDaoSourceFake @Inject constructor() : CafeDaoSource {
    private val citiesList = listOf("Taipei", "Taichung", "Tainan", "Kaohsiung")
    private val cafeList = MutableList(100) {
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
    override val cafeCount: Flow<Int> = flow { emit(cafeList.size) }
    override val cafes: Flow<List<CafeNomad>> = flow { emit(cafeList) }
    override val cities: Flow<List<String>> = flow { emit(citiesList) }

    override suspend fun insert(vararg cafeNomad: CafeNomad) {
    }

    override fun cafes(
        tasty: Float,
        cheap: Float,
        quiet: Float,
        music: Float,
        seat: Float,
        wifi: Float,
        vararg cities: String
    ): Flow<List<CafeNomad>> = flow {
        cafeList.filter {
            it.tasty >= tasty && it.cheap >= cheap && it.quiet >= quiet &&
                    it.music >= music && it.seat >= seat && it.wifi >= wifi && cities.contains(it.city)
        }
    }
}