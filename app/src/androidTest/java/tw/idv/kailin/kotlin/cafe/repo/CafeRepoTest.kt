package tw.idv.kailin.kotlin.cafe.repo

import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import tw.idv.kailin.kotlin.cafe.di.DSModule
import tw.idv.kailin.kotlin.cafe.di.RepoViewModelModule
import tw.idv.kailin.kotlin.cafe.repo.cafe.CafeRepo
import tw.idv.kailin.kotlin.cafe.repo.ds.*
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@UninstallModules(DSModule::class, RepoViewModelModule::class)
@HiltAndroidTest
class CafeRepoTest {

    @Inject
    lateinit var repo: CafeRepo

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun cities() = runTest {
        repo.cities.collect {
            assertEquals("Taipei", it[0])
            assertEquals("Kaohsiung", it[3])
            println(it.toString())
        }
    }

    @Test
    fun cafes() = runTest {
        repo.cafes.collect {
            assertEquals(100, it.size)
        }
    }

    @Test
    fun cafeFilter() = runTest {
        val cities = listOf("Taipei", "Kaohsiung").toTypedArray()
        repo.filterCafes(
            4f, 4f, 4f, 4f, 4f, 4f, *cities
        ).collect {
            it.forEach { cafe ->
                assertTrue(cafe.tasty >= 4f)
                assertTrue(cafe.cheap >= 4f)
                assertTrue(cafe.quiet >= 4f)
                assertTrue(cafe.music >= 4f)
                assertTrue(cafe.seat >= 4f)
                assertTrue(cafe.wifi >= 4f)
                assertTrue(cities.contains(cafe.city))
            }
        }
    }
}