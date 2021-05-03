package com.example.academy.ui.academy

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

import org.junit.Before

class AcademyViewModelTest {

    private lateinit var vm: AcademyViewModel

    @Before
    fun setUp() {
        vm = AcademyViewModel()
    }

    @Test
    fun getCourses() {
        val courseEntities = vm.getCourses()
        assertNotNull(courseEntities)
        assertEquals(5, courseEntities.size)
    }
}