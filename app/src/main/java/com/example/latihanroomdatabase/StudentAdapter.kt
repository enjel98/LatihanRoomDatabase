package com.example.latihanroomdatabase

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.latihanroomdatabase.databinding.ItemStudentBinding
import com.example.latihanroomdatabase.db.Student

class StudentAdapter(private val onClick: (student: Student) -> Unit) :
    RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    var students = emptyList<Student>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val binding = ItemStudentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StudentViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return students.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(students[position])

    }

    inner class StudentViewHolder(private val binding: ItemStudentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.btnDelete.setOnClickListener {
                onClick(students[position])
            }
        }

        fun bind(student: Student) {
            binding.tvNama.text = student.nama
            binding.tvNim.text = student.nim
        }


    }
}