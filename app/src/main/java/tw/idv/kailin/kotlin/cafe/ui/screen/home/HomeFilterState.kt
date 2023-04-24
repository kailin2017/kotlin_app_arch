package tw.idv.kailin.kotlin.cafe.ui.screen.home

data class HomeFilterState(
    val tasty: Float = 0f,
    val cheap: Float = 0f,
    val quiet: Float = 0f,
    val music: Float = 0f,
    val seat: Float = 0f,
    val wifi: Float = 0f,
    val cities: List<String> = listOf()
)
