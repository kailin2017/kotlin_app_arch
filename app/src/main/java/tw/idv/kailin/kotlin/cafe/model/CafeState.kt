package tw.idv.kailin.kotlin.cafe.model

data class CafeState(
    override val status: RepoStatus,
    override val data: List<CafeNomad>? = null,
    override val message: String? = null,
    override val throwable: Throwable? = null,
    override val location: String? = null
) : RepoState<List<CafeNomad>>