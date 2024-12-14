package com.example.focusscore.presentation.focus

import assertk.assertThat
import assertk.assertions.isEqualTo
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
    fun `Focus Score changes every 5 seconds`() = runTest {


        viewModel.focusScoreRandomized()
        advanceTimeBy(6000)
        val firstScore = viewModel.state.value.focusScore

        assertThat(firstScore).isEqualTo(2)





    }



}