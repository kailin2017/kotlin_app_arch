package tw.idv.kailin.kotlin.cafe.repo

import tw.idv.kailin.kotlin.cafe.model.CafeNomad
import tw.idv.kailin.kotlin.cafe.model.CafeState
import tw.idv.kailin.kotlin.cafe.repo.ds.CafeApiSource
import tw.idv.kailin.kotlin.cafe.repo.ds.CafeDaoSource
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import tw.idv.kailin.kotlin.cafe.model.RepoStatus
import javax.inject.Inject

class CafeRepoImpl @Inject constructor(
    apiSource: CafeApiSource,
    private val daoSource: CafeDaoSource,
) : CafeRepo {

    override val cafes: Flow<List<CafeNomad>> = daoSource.cafes
    override val cities: Flow<List<String>> = daoSource.cities

    private val localCafes: Flow<Int> = daoSource.cafeCount
    private val updateCafes: Flow<CafeState> = apiSource.cafes.onEach {
        if (it.status == RepoStatus.Success) {
            it.data?.toTypedArray()?.let { data -> daoSource.insert(*data) }
        }
    }

    @OptIn(FlowPreview::class)
    override val repoState: Flow<CafeState> = localCafes.flatMapConcat {
        return@flatMapConcat if (it == 0) {
            updateCafes
        } else {
            flowOf(CafeState(RepoStatus.Success))
        }
    }

    override fun cafes(vararg cities:String) = daoSource.cafes(*cities)
}
