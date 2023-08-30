package com.example.proyfinal

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.proyfinal.model.Comparo
import com.example.proyfinal.view.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test


@Suppress("DEPRECATION")
@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelUnitTest {

    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun mainViewModel_CheckInitialValue() = runTest {
        assertEquals(null, viewModel.comparo.value)
    }

    @Test
    fun mainViewModel_ComparoTest() = runTest{
        launch {
            viewModel.fComparar("texto", "texto")
        }
        advanceUntilIdle()
        val resultadoTest = viewModel.comparo.value?.bResultado
        assertTrue(resultadoTest!!)
    }
}

