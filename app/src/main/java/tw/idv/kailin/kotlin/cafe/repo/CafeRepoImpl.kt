package tw.idv.kailin.kotlin.cafe.repo

import tw.idv.kailin.kotlin.cafe.CafeNomad
import tw.idv.kailin.kotlin.cafe.CafeState
import tw.idv.kailin.kotlin.cafe.RepoStatus
import tw.idv.kailin.kotlin.cafe.repo.ds.CafeApiSource
import tw.idv.kailin.kotlin.cafe.repo.ds.CafeDaoSource
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class CafeRepoImpl @Inject constructor(
    apiSource: CafeApiSource,
    private val daoSource: CafeDaoSource,
) : CafeRepo {

    private val localCafes: Flow<List<CafeNomad>> = daoSource.cafes
    private val updateCafes: Flow<CafeState> = apiSource.cafes.onEach {
        if (it.status == RepoStatus.Success) {
            it.data?.toTypedArray()?.let { data -> daoSource.insert(*data) }
        }
    }

    @OptIn(FlowPreview::class)
    override val repoState: Flow<CafeState> = localCafes.flatMapConcat {
        return@flatMapConcat if (it.isEmpty()) {
            updateCafes
        } else {
            flowOf(CafeState(RepoStatus.Success, data = it))
        }
    }
}
