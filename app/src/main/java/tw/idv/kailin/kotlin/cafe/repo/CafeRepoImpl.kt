package tw.idv.kailin.kotlin.cafe.repo

import tw.idv.kailin.kotlin.cafe.model.CafeNomad
import tw.idv.kailin.kotlin.cafe.model.CafeState
import tw.idv.kailin.kotlin.cafe.repo.ds.CafeApiSource
import tw.idv.kailin.kotlin.cafe.repo.ds.CafeDaoSource
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import tw.idv.kailin.kotlin.cafe.model.RepoStatus
import javax.inject.Inject

@OptIn(FlowPreview::class)
class CafeRepoImpl @Inject constructor(
    apiSource: CafeApiSource,
    private val daoSource: CafeDaoSource,
) : CafeRepo {

    override val cafes: Flow<List<CafeNomad>> = daoSource.cafes
    override val cities: Flow<List<String>> = daoSource.cities

    override val cafeFlow: Flow<CafeState> = daoSource.cafes.flatMapConcat {
        return@flatMapConcat if (it.isEmpty()) {
            apiSource.cafes.onEach { state ->
                if (state.status == RepoStatus.Success) {
                    state.data?.toTypedArray()?.let { data -> daoSource.insert(*data) }
                }
            }
        } else {
            flowOf(CafeState(RepoStatus.Success, data = it))
        }
    }

    override val repoState: Flow<CafeState> = daoSource.cafeCount.flatMapConcat {
        return@flatMapConcat if (it == 0) {
            apiSource.cafes.onEach { state ->
                if (state.status == RepoStatus.Success) {
                    state.data?.toTypedArray()?.let { data -> daoSource.insert(*data) }
                }
            }
        } else {
            flowOf(CafeState(RepoStatus.Success))
        }
    }

    override fun cafes(vararg cities: String) = daoSource.cafes(*cities)

    override fun cafes(
        tasty: Float,
        cheap: Float,
        quiet: Float,
        music: Float,
        seat: Float,
        wifi: Float,
        vararg cities: String
    ) = daoSource.cafes(tasty, cheap, quiet, music, seat, wifi, *cities)
}
