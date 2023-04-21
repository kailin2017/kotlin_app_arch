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
import tw.idv.kailin.kotlin.cafe.di.RepoModule
import tw.idv.kailin.kotlin.cafe.model.RepoStatus
import tw.idv.kailin.kotlin.cafe.repo.ds.*
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@UninstallModules(DSModule::class, RepoModule::class)
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
            assertEquals(10, it.size)
            println(it.toString())
        }
    }

    @Test
    fun cafesByCities() = runTest {
        val array = arrayOf("Taipei", "Kaohsiung")
        repo.cafes(*array).collect {
            println(it.toString())
            assertTrue(it.all { cafeNomad ->
                array.contains(cafeNomad.city)
            })
        }
    }

    @Test
    fun status() = runTest {
        repo.repoState.collect {
            assertEquals(RepoStatus.Success, it.status)
            println(it.toString())
        }
    }
}