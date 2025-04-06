package com.luisgmr.lynxapp.presentation.ui.students

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.luisgmr.lynxapp.data.model.Student
import com.luisgmr.lynxapp.data.repository.StudentRepository
import com.luisgmr.lynxapp.presentation.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class StudentsViewModel @Inject constructor(
    private val studentRepository: StudentRepository
) : ViewModel() {

    private val _students = MutableStateFlow<List<Student>>(emptyList())
    val students: StateFlow<List<Student>> = _students

    init {
        loadStudents()
    }

    fun loadStudents() {
        _students.value = studentRepository.getAll()
    }

    fun deleteStudent(student: Student) {
        studentRepository.delete(student)
        loadStudents()
    }

    fun goToStudentForm(navController: NavController, studentId: String) {
        navController.navigate(Screen.StudentEdit.createRoute(studentId))
    }
}
