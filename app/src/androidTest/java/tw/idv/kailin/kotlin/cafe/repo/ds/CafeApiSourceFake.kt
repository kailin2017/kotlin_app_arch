package tw.idv.kailin.kotlin.cafe.repo.ds

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import tw.idv.kailin.kotlin.cafe.model.CafeNomad
import tw.idv.kailin.kotlin.cafe.model.CafeState
import tw.idv.kailin.kotlin.cafe.model.RepoStatus
import tw.idv.kailin.kotlin.cafe.repo.cafe.CafeApiSource
import javax.inject.Inject

class CafeApiSourceFake @Inject constructor(): CafeApiSource {

    override suspend fun cafes(): List<CafeNomad> {
        return listOf()
    }
}