package com.def.roomsampleapp.fragment

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.def.roomsampleapp.model.Student

class StudentAdapter(diffCallback: DiffUtil.ItemCallback<Student>): ListAdapter<Student, StudentViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        return StudentViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        var student = getItem(position) as Student
        holder.bind(student.name+" "+student.surname)
    }
}