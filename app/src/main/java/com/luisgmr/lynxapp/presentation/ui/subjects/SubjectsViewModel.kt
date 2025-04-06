package com.luisgmr.lynxapp.presentation.ui.subjects

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.luisgmr.lynxapp.data.model.Subject
import com.luisgmr.lynxapp.data.repository.StudentRepository
import com.luisgmr.lynxapp.data.repository.SubjectRepository
import com.luisgmr.lynxapp.presentation.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SubjectsViewModel @Inject constructor(
    private val subjectRepository: SubjectRepository,
    private val studentRepository: StudentRepository
) : ViewModel() {

    private val _subjects = MutableStateFlow<List<Subject>>(emptyList())
    val subjects: StateFlow<List<Subject>> = _subjects

    init {
        loadSubjects()
    }

    fun loadSubjects() {
        _subjects.value = subjectRepository.getAll()
    }

    fun deleteSubject(subject: Subject) {
        subjectRepository.delete(subject)
        studentRepository.getAll().forEach { student ->
            student.subjects.remove(subject)
        }
        loadSubjects()
    }

    fun goToSubjectForm(navController: NavController, subjectId: String) {
         navController.navigate(Screen.SubjectEdit.createRoute(subjectId))
    }
}
