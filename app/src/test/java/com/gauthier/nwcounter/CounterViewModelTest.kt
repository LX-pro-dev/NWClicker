package com.gauthier.nwcounter

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import androidx.arch.core.executor.testing.InstantTaskExecutorRule

/**
 *Created by Alexandre GAUTHIER on 16/05/2023.
 */
class CounterViewModelTest {
    private lateinit var counterViewModel: CounterViewModel

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        counterViewModel = CounterViewModel()
    }

    @Test
    fun testCounterInitialValue() {
        val initialValue = counterViewModel.counter.value
        assertEquals(initialValue, 0)
    }

    @Test
    fun testCounterIncrement() {
        counterViewModel.incrementCounter()
        val currentValue = counterViewModel.counter.value
        assertEquals(currentValue, 1)
    }

    @Test
    fun testCounterReset() {
        counterViewModel.incrementCounter()
        counterViewModel.resetCounter()
        val currentValue = counterViewModel.counter.value
        assertEquals(currentValue, 0)
    }
}
