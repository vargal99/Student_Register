package com.example.android.studentregisterroomsqllite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.studentregisterroomsqllite.databinding.ActivityMainBinding
import com.example.android.studentregisterroomsqllite.databinding.ListItemBinding
import com.example.android.studentregisterroomsqllite.db.Student

class StudentRecyclerViewAdapter(
    private val clickListener:(Student)->Unit
):RecyclerView.Adapter<StudentViewHolder>()  {

    private val studentList = ArrayList<Student>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return StudentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(studentList[position],clickListener)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    fun setList(students:List<Student>){
        studentList.clear()
        studentList.addAll(students)
    }

}


class StudentViewHolder(private val binding: ListItemBinding):RecyclerView.ViewHolder(binding.root){
    fun bind(student: Student,clickListener:(Student)->Unit){
        binding.apply {
            tvName.text = student.name
            tvEmail.text = student.email
            /*
            val nameTextView = view.findViewById<TextView>(R.id.tvName)
            val emailTextView = view.findViewById<TextView>(R.id.tvEmail)
            nameTextView.text = student.name
            emailTextView.text = student.email

             */
            root.setOnClickListener {
                clickListener(student)
            }
        }
    }
}