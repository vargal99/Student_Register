package com.example.android.studentregisterroomsqllite



import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.studentregisterroomsqllite.db.StudentDao


class StudentViewModelFactory(
    private val dao: StudentDao
):ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StudentViewModel::class.java)){
            return StudentViewModel(dao) as T
        }
        throw IllegalAccessException("Unkonw View Model Class")
    }

}

