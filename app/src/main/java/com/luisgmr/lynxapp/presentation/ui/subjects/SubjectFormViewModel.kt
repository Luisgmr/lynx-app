package com.luisgmr.lynxapp.presentation.ui.subjects

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.luisgmr.lynxapp.data.model.Subject
import com.luisgmr.lynxapp.data.repository.SubjectRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SubjectFormViewModel @Inject constructor(
    private val subjectRepository: SubjectRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val subjectId: String = savedStateHandle["id"] ?: "new"

    val isEditMode: Boolean
        get() = subjectId != "new"

    var name by mutableStateOf("")

    init {
        loadFormData()
    }

    private fun loadFormData() {
        if (isEditMode) {
            val existing = subjectRepository.getById(subjectId)
            existing?.let {
                name = it.name
            }
        }
    }

    fun onNameChange(newName: String) {
        name = newName
    }

    fun save() {
        if (name.isBlank()) return

        if (isEditMode) {
            val existing = subjectRepository.getById(subjectId)
            if (existing != null) {
                existing.name = name
                subjectRepository.update(existing)
            }
        } else {
            val newSubject = Subject(name = name)
            subjectRepository.add(newSubject)
        }
    }
}
