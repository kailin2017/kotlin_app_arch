package tw.idv.kailin.kotlin.cafe.repo.cafe

import kotlinx.coroutines.flow.Flow
import tw.idv.kailin.kotlin.cafe.model.CafeNomad
import javax.inject.Inject

class CafeRepoImpl @Inject constructor(
    private val apiSource: CafeApiSource,
    private val daoSource: CafeDaoSource,
) : CafeRepo {

    override val cities: Flow<List<String>> = daoSource.cities
    override val cafes: Flow<List<CafeNomad>> = daoSource.cafes

    override fun filterCafes(
        tasty: Float,
        cheap: Float,
        quiet: Float,
        music: Float,
        seat: Float,
        wifi: Float,
        vararg cities: String
    ) = daoSource.cafes(tasty, cheap, quiet, music, seat, wifi, *cities)

    override suspend fun updateCafes() {
        val cafes = apiSource.cafes()
        daoSource.insert(*cafes.toTypedArray())
    }
}
