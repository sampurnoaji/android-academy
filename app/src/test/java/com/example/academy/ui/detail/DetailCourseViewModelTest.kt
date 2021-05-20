package com.example.academy.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.academy.data.AcademyRepository
import com.example.academy.data.source.local.entity.CourseWithModule
import com.example.academy.utils.DataDummy
import com.example.academy.vo.Resource
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailCourseViewModelTest {

    private lateinit var vm: DetailCourseViewModel
    private val dummyCourse = DataDummy.generateDummyCourses()[0]
    private val courseId = dummyCourse.courseId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var academyRepository: AcademyRepository

    @Mock
    private lateinit var observer: Observer<Resource<CourseWithModule>>

    @Before
    fun setUp() {
        vm = DetailCourseViewModel(academyRepository)
        vm.setSelectedCourse(courseId)
    }

    @Test
    fun getCourseWithModule() {
        val dummyCourseWithModule =
            Resource.success(DataDummy.generateDummyCourseWithModules(dummyCourse, true))
        val course = MutableLiveData<Resource<CourseWithModule>>()
        course.value = dummyCourseWithModule
        `when`(academyRepository.getCourseWithModules(courseId)).thenReturn(course)
        vm.courseModule.observeForever(observer)
        verify(observer).onChanged(dummyCourseWithModule)
    }
}