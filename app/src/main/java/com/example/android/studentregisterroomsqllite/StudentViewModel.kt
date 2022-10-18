package com.example.android.studentregisterroomsqllite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.studentregisterroomsqllite.db.Student
import com.example.android.studentregisterroomsqllite.db.StudentDao
import kotlinx.coroutines.launch

class StudentViewModel(private val dao: StudentDao): ViewModel() {

    val students = dao.getAllstundets()

    fun insertStudent(student: Student) = viewModelScope.launch {
        dao.insertStudent(student)
    }

    fun updateStudent(student: Student) = viewModelScope.launch {
        dao.updateStudent(student)
    }

    fun deleteStudent(student: Student) = viewModelScope.launch {
        dao.deleteStudent(student)
    }
}