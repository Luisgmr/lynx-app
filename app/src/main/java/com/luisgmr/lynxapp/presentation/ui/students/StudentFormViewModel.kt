package com.luisgmr.lynxapp.presentation.ui.students

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.luisgmr.lynxapp.data.model.Student
import com.luisgmr.lynxapp.data.model.Subject
import com.luisgmr.lynxapp.data.repository.StudentRepository
import com.luisgmr.lynxapp.data.repository.SubjectRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StudentFormViewModel @Inject constructor(
    private val studentRepository: StudentRepository,
    private val subjectRepository: SubjectRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    // "id" recebido pela rota (student_edit?id=...)
    private val studentId: String = savedStateHandle["id"] ?: "new"

    // Se for "new", é criação; caso contrário, é edição
    val isEditMode: Boolean
        get() = studentId != "new"

    // Campos do formulário
    var name by mutableStateOf("")
    var allSubjects by mutableStateOf<List<Subject>>(emptyList())
    var selectedSubjects = mutableStateListOf<Subject>()
        private set

    init {
        loadFormData()
    }

    private fun loadFormData() {
        allSubjects = subjectRepository.getAll()

        if (isEditMode) {
            val existing = studentRepository.getById(studentId)
            existing?.let {
                name = it.name
                selectedSubjects.clear()
                selectedSubjects.addAll(it.subjects)
            }
        }
    }

    fun onNameChange(newName: String) {
        name = newName
    }

    fun toggleSubject(subject: Subject) {
        if (selectedSubjects.contains(subject)) {
            selectedSubjects.remove(subject)
        } else {
            selectedSubjects.add(subject)
        }
    }

    fun save() {
        // Se não tem nome, não salva
        if (name.isBlank()) return

        if (isEditMode) {
            // Edição
            val existing = studentRepository.getById(studentId)
            if (existing != null) {
                existing.name = name
                existing.subjects.apply {
                    clear()
                    addAll(selectedSubjects)
                }
                studentRepository.update(existing)
            }
        } else {
            // Criação
            val newStudent = Student(
                name = name,
                subjects = selectedSubjects.toMutableList()
            )
            studentRepository.add(newStudent)
        }
    }
}
