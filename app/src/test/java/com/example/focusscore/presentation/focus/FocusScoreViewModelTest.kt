package com.example.focusscore.presentation.focus

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isNotEqualTo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@OptIn(ExperimentalCoroutinesApi::class)
class FocusScoreViewModelTest {

    private lateinit var viewModel: FocusScoreViewModel

    @BeforeEach
    fun setUp() {
        val testDispatcher = StandardTestDispatcher()
        Dispatchers.setMain(testDispatcher)

        viewModel = FocusScoreViewModel()
    }

    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `Focus Score changes after 5 seconds`() = runTest {


        viewModel.focusScoreRandomized()

        val initalScore = viewModel.state.value.focusScore

        assertThat(initalScore).isEqualTo(0)

        advanceTimeBy(6000)

        val newScore = viewModel.state.value.focusScore


        assertThat(initalScore).isNotEqualTo(newScore)







    }



}