package com.example.academy.ui.detail

import com.example.academy.utils.DataDummy
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class DetailCourseViewModelTest {

    private lateinit var vm: DetailCourseViewModel
    private val dummyCourse = DataDummy.generateDummyCourses()[0]
    private val courseId = dummyCourse.courseId

    @Before
    fun setUp() {
        vm = DetailCourseViewModel()
        vm.setSelectedCourse(courseId)
    }

    @Test
    fun getCourse() {
        vm.setSelectedCourse(dummyCourse.courseId)
        val courseEntity = vm.getCourse()
        assertNotNull(courseEntity)
        assertEquals(dummyCourse.courseId, courseEntity.courseId)
        assertEquals(dummyCourse.deadline, courseEntity.deadline)
        assertEquals(dummyCourse.description, courseEntity.description)
        assertEquals(dummyCourse.imagePath, courseEntity.imagePath)
        assertEquals(dummyCourse.title, courseEntity.title)
    }

    @Test
    fun getModules() {
        val moduleEntities = vm.getModules()
        assertNotNull(moduleEntities)
        assertEquals(7, moduleEntities.size)
    }
}